package dev.darshan.buildex.dto.member;

import dev.darshan.buildex.enums.ProjectMemberRole;

public record InviteMemberRequest(
        String email,
        ProjectMemberRole role
) {
}
