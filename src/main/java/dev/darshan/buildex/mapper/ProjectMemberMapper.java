package dev.darshan.buildex.mapper;

import dev.darshan.buildex.dto.member.ProjectMemberResponse;
import dev.darshan.buildex.entity.ProjectMember;
import dev.darshan.buildex.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target = "role", constant = "OWNER")
    ProjectMemberResponse toProjectMemberResponse(User Owner);

    ProjectMemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);

}
