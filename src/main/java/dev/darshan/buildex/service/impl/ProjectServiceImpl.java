package dev.darshan.buildex.service.impl;

import dev.darshan.buildex.dto.project.ProjectRequest;
import dev.darshan.buildex.dto.project.ProjectResponse;
import dev.darshan.buildex.dto.project.ProjectSummaryResponse;
import dev.darshan.buildex.entity.Project;
import dev.darshan.buildex.entity.ProjectMember;
import dev.darshan.buildex.entity.ProjectMemberId;
import dev.darshan.buildex.entity.User;
import dev.darshan.buildex.enums.ProjectMemberRole;
import dev.darshan.buildex.error.exceptions.ResourceNotFoundException;
import dev.darshan.buildex.mapper.ProjectMapper;
import dev.darshan.buildex.repository.ProjectMemberRepository;
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
    ProjectMemberRepository projectMemberRepository;


    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return projectMapper.toProjectSummaryResponseList(projectRepository.findAllAccessibleByUser(userId));
    }

    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest, Long userId) {

        User owner = userRepository.findById(userId).orElseThrow();

        Project project = Project.builder()
                .name(projectRequest.projectName())
                .isPublic(false) // default visibility of project
                .build();

        projectRepository.save(project);

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .projectMemberId(projectMemberId)
                .memberRole(ProjectMemberRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();

        projectMemberRepository.save(projectMember);

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


        project.setDeletedAt(Instant.now());
        projectRepository.save(project);

    }



    /// Internal Methods

    private Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow(()->
                new ResourceNotFoundException("Project", projectId.toString()));
    }
}
