package dev.darshan.buildex.controller;

import dev.darshan.buildex.dto.auth.AuthResponse;
import dev.darshan.buildex.dto.auth.LogInRequest;
import dev.darshan.buildex.dto.auth.SignUpRequest;
import dev.darshan.buildex.dto.auth.UserProfileResponse;
import dev.darshan.buildex.service.AuthService;
import dev.darshan.buildex.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {

    AuthService authService;
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> logIn(@RequestBody LogInRequest logInRequest) {
        return ResponseEntity.ok(authService.logIn(logInRequest));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getUserProfile() {
        Long userId = 1L;
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }

}
