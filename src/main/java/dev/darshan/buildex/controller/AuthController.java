package dev.darshan.buildex.controller;

import dev.darshan.buildex.dto.auth.AuthResponse;
import dev.darshan.buildex.dto.auth.LogInRequest;
import dev.darshan.buildex.dto.auth.SignUpRequest;
import dev.darshan.buildex.dto.auth.UserProfileResponse;
import dev.darshan.buildex.service.AuthService;
import dev.darshan.buildex.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> logIn(LogInRequest logInRequest) {
        return ResponseEntity.ok(authService.logIn(logInRequest));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getUserProfile() {
        Long userId = 1L;
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }

}
