package dev.darshan.buildex.controller;


import dev.darshan.buildex.dto.Subscription.PlanLimitResponse;
import dev.darshan.buildex.dto.Subscription.TokenUsageTodayResponse;
import dev.darshan.buildex.service.UsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/usage")
public class UsageController {

    private final UsageService usageService;

    @GetMapping("/today")
    public ResponseEntity<TokenUsageTodayResponse> getTokenUsageToday(){
        Long userId = 1L;
        return ResponseEntity.ok(usageService.getTodayUsageOfUser(userId));
    }

    @GetMapping("/limits")
    public ResponseEntity<PlanLimitResponse> getCurrentPlanLimitOfUser(){
        Long userId = 1L;
        return ResponseEntity.ok(usageService.getCurrentPlanLimitOfUser(userId));
    }
}
