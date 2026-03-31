package dev.darshan.buildex.controller;

import dev.darshan.buildex.dto.project.ProjectRequest;
import dev.darshan.buildex.dto.project.ProjectResponse;
import dev.darshan.buildex.dto.project.ProjectSummaryResponse;
import dev.darshan.buildex.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectSummaryResponse>> getMyProjects() {
        Long userId = 1L;
        return ResponseEntity.ok(projectService.getUserProjects(userId));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<List<ProjectSummaryResponse>> getProjectById(@PathVariable Long projectId) {
        Long userId = 1L;
        return ResponseEntity.ok(projectService.getProjectById(projectId, userId));
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest projectRequest) {
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(projectRequest, userId));
    }

    @PatchMapping("/{projectId}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long projectId, @RequestBody ProjectRequest projectRequest) {
        Long userId = 1L;
        return ResponseEntity.ok(projectService.updateProject(projectId, projectRequest, userId));
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long projectId) {
        Long userId = 1L;
        projectService.softDelete(projectId, userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
