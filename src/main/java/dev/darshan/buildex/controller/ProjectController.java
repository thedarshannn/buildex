package dev.darshan.buildex.controller;

import dev.darshan.buildex.dto.project.ProjectSummaryReponse;
import dev.darshan.buildex.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectSummaryReponse>> getMyProjects(){
        Long userId = 1L;
        return ResponseEntity.ok(projectService.getUserProjects(userId));
    }

}
