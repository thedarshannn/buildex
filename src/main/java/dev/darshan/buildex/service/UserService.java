package dev.darshan.buildex.service;

import dev.darshan.buildex.dto.auth.UserProfileResponse;


public interface UserService {

    UserProfileResponse getUserProfile(Long userId);
}
