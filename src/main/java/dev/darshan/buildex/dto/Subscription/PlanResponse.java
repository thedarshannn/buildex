package dev.darshan.buildex.dto.Subscription;

public record PlanResponse(
        Long id,
        String name,
        String stripePriceId,
        Integer maxProjects,
        Integer maxTokensPerday,
        Integer maxPreviews, // Maximum number of previews allowed per plan.
        Boolean unlimitedAi, // Unlimited access to LLMs, ignore the maxTokensPerday if true.
        Boolean active
) {
}
