package dev.darshan.buildex.service;


import dev.darshan.buildex.dto.auth.AuthResponse;
import dev.darshan.buildex.dto.auth.SignUpRequest;

public interface AuthService {
     AuthResponse signUp(SignUpRequest signUpRequest);
}
