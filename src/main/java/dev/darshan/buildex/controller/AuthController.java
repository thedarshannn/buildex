package dev.darshan.buildex.controller;

import dev.darshan.buildex.dto.auth.AuthResponse;
import dev.darshan.buildex.dto.auth.LogInRequest;
import dev.darshan.buildex.dto.auth.SignUpRequest;
import dev.darshan.buildex.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @RequestMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }

    @RequestMapping("/login")
    public ResponseEntity<AuthResponse> logIn(LogInRequest logInRequest) {
        return ResponseEntity.ok(authService.logIn(logInRequest));
    }

}
