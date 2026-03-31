package dev.darshan.buildex.service;

import dev.darshan.buildex.dto.Subscription.PlanResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
