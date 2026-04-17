package dev.darshan.buildex.service;

import dev.darshan.buildex.dto.Subscription.PlanResponse;

import java.util.List;


public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
