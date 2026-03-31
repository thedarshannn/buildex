package dev.darshan.buildex.service;


import dev.darshan.buildex.dto.auth.AuthResponse;
import dev.darshan.buildex.dto.auth.LogInRequest;
import dev.darshan.buildex.dto.auth.SignUpRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
     AuthResponse signUp(SignUpRequest signUpRequest);

     AuthResponse logIn(LogInRequest logInRequest);
}
