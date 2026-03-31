package dev.darshan.buildex.service;

import dev.darshan.buildex.dto.Subscription.PlanLimitResponse;
import dev.darshan.buildex.dto.Subscription.TokenUsageTodayResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public interface UsageService {
    TokenUsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitResponse getCurrentSubscriptionLimitOfUser(Long userId);

    PlanLimitResponse getCurrentPlanLimitOfUser(Long userId);
}
