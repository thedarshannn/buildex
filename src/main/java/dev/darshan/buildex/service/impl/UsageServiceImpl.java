package dev.darshan.buildex.service.impl;

import dev.darshan.buildex.dto.Subscription.PlanLimitResponse;
import dev.darshan.buildex.dto.Subscription.TokenUsageTodayResponse;
import dev.darshan.buildex.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {

    @Override
    public TokenUsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitResponse getCurrentSubscriptionLimitOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitResponse getCurrentPlanLimitOfUser(Long userId) {
        return null;
    }
}
