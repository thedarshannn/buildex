package dev.darshan.buildex.service.impl;

import dev.darshan.buildex.dto.auth.AuthResponse;
import dev.darshan.buildex.dto.auth.LogInRequest;
import dev.darshan.buildex.dto.auth.SignUpRequest;
import dev.darshan.buildex.mapper.UserMapper;
import dev.darshan.buildex.repository.UserRepository;
import dev.darshan.buildex.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {


    UserRepository userRepository;
    UserMapper userMapper;


    @Override
    public AuthResponse signUp(SignUpRequest signUpRequest) {


        return null;
    }

    @Override
    public AuthResponse logIn(LogInRequest logInRequest) {
        return null;
    }
}
