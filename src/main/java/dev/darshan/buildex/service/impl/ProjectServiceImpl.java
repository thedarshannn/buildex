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
        return List.of();
    }

    /**
     * Creates a new project with the specified details for a given user.
     *
     * @param projectRequest the details of the project to create
     * @param userId the ID of the user creating the project
     * @return a {@link ProjectResponse} containing details of the created project
     */
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
    public List<ProjectSummaryResponse> getProjectById(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public ProjectResponse updateProject(Long projectId, ProjectRequest projectRequest, Long userId) {
        return null;
    }

    @Override
    public void softDelete(Long projectId, Long userId) {

    }
}
