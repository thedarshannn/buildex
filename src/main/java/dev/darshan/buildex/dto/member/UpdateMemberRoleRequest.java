package dev.darshan.buildex.dto.member;

import dev.darshan.buildex.enums.ProjectMemberRole;

public record UpdateMemberRoleRequest(
        ProjectMemberRole role
) {
}
