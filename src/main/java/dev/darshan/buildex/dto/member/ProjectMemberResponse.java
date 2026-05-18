package dev.darshan.buildex.dto.member;

import dev.darshan.buildex.enums.ProjectMemberRole;

import java.time.Instant;

public record ProjectMemberResponse(
        Long id,
        String email,
        String name,
        String avatarUrl,
        ProjectMemberRole role,
        Instant invitedAt
) {
}
