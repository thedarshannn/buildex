package dev.darshan.buildex.dto.Subscription;

public record PlanLimitResponse(
        String planName,
        int maxTokensPerDay,
        int maxProjects,
        boolean unlimitedAI
) {
}
