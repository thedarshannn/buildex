package dev.darshan.buildex.service.impl;

import dev.darshan.buildex.dto.Subscription.PlanResponse;
import dev.darshan.buildex.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
