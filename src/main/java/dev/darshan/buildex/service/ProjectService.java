package dev.darshan.buildex.service;

import dev.darshan.buildex.dto.project.ProjectSummaryReponse;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryReponse> getUserProjects(Long userId);
}
