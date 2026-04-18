package dev.darshan.buildex.mapper;

import dev.darshan.buildex.dto.project.ProjectResponse;
import dev.darshan.buildex.entity.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);
}
