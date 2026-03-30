package dev.darshan.buildex.dto.project;

import dev.darshan.buildex.dto.auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String projectName,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponse owner
) {
}
