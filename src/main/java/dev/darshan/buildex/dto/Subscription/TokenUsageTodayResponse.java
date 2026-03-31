package dev.darshan.buildex.dto.Subscription;

public record TokenUsageTodayResponse(
        int tokensUsed,
        int tokenLimit,
        int previewsRunning,
        int previewsLimit
) {
}
