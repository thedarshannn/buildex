package dev.darshan.buildex.service.impl;

import dev.darshan.buildex.dto.project.ProjectRequest;
import dev.darshan.buildex.dto.project.ProjectResponse;
import dev.darshan.buildex.dto.project.ProjectSummaryResponse;
import dev.darshan.buildex.entity.Project;
import dev.darshan.buildex.entity.User;
import dev.darshan.buildex.mapper.ProjectMapper;
import dev.darshan.buildex.repository.ProjectRepository;
import dev.darshan.buildex.repository.UserRepository;
import dev.darshan.buildex.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

/**
 * Service implementation for managing projects.
 * Handles the creation, retrieval, updating, and soft deletion of projects.
 * This class is transactional, ensuring atomic operations on methods.
 */
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Transactional // All the methods would be transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;


    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return projectMapper.toProjectSummaryResponseList(projectRepository.findAllAccessibleByUser(userId));
    }

    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest, Long userId) {

        User user = userRepository.findById(userId).orElseThrow();

        Project project = Project.builder()
                .name(projectRequest.projectName())
                .owner(user)
                .isPublic(false) // default visibility of project
                .build();

        projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse getProjectById(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long projectId, ProjectRequest projectRequest, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        project.setName(projectRequest.projectName());
        project = projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        // If a user is not the owner, they do not have right to delete.
        if (!project.getOwner().getId().equals(userId)){
            throw  new RuntimeException("You are not allowed to delete!");
        }

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);

    }



    /// Internal Methods

    private Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow();
    }
}
