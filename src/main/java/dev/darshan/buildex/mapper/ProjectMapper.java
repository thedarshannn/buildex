package dev.darshan.buildex.mapper;

import dev.darshan.buildex.dto.project.ProjectResponse;
import dev.darshan.buildex.dto.project.ProjectSummaryResponse;
import dev.darshan.buildex.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mapping(target = "projectName", source = "name")
    ProjectResponse toProjectResponse(Project project);


    @Mapping(target = "projectName", source = "name")
    ProjectSummaryResponse toProjectSummaryResponse(Project project);

    @Mapping(target = "projectName", source = "name")
    List<ProjectSummaryResponse> toProjectSummaryResponseList(List<Project> project);
}
