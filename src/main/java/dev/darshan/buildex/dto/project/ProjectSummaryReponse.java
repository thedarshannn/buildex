package dev.darshan.buildex.dto.project;

import java.time.Instant;

public record ProjectSummaryReponse(
        Long id,
        String projectName,
        Instant createdAt,
        Instant updatedAt
) {
}
