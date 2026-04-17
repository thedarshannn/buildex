package dev.darshan.buildex.dto.Subscription;

public record TokenUsageTodayResponse(
        Integer tokensUsed,
        Integer tokenLimit,
        Integer previewsRunning,
        Integer previewsLimit
) {
}
