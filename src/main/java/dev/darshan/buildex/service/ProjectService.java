package dev.darshan.buildex.service;

import dev.darshan.buildex.dto.project.ProjectRequest;
import dev.darshan.buildex.dto.project.ProjectResponse;
import dev.darshan.buildex.dto.project.ProjectSummaryResponse;


import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse createProject(ProjectRequest projectRequest, Long userId);

    List<ProjectSummaryResponse> getProjectById(Long projectId, Long userId);

    ProjectResponse updateProject(Long projectId, ProjectRequest projectRequest, Long userId);

    void softDelete(Long projectId, Long userId);
}
