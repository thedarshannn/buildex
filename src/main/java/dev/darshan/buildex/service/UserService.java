package dev.darshan.buildex.service;

import dev.darshan.buildex.dto.auth.UserProfileResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserProfileResponse getUserProfile(Long userId);
}
