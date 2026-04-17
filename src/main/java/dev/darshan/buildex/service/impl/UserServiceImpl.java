package dev.darshan.buildex.service.impl;

import dev.darshan.buildex.dto.auth.UserProfileResponse;
import dev.darshan.buildex.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public UserProfileResponse getUserProfile(Long userId) {
        return null;
    }
}
