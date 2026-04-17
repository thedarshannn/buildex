package dev.darshan.buildex.service;

import dev.darshan.buildex.dto.Subscription.PlanLimitResponse;
import dev.darshan.buildex.dto.Subscription.TokenUsageTodayResponse;


public interface UsageService {
    TokenUsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitResponse getCurrentSubscriptionLimitOfUser(Long userId);

    PlanLimitResponse getCurrentPlanLimitOfUser(Long userId);
}
