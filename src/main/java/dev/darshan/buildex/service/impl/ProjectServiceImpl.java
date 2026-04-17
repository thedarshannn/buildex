package dev.darshan.buildex.service.impl;

import dev.darshan.buildex.dto.project.ProjectRequest;
import dev.darshan.buildex.dto.project.ProjectResponse;
import dev.darshan.buildex.dto.project.ProjectSummaryResponse;
import dev.darshan.buildex.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {


    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return List.of();
    }

    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest, Long userId) {
        return null;
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
