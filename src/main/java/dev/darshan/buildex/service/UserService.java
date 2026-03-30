package dev.darshan.buildex.service;

import dev.darshan.buildex.dto.auth.UserProfileResponse;
import org.jspecify.annotations.Nullable;

public interface UserService {

    UserProfileResponse getUserProfile(Long userId);
}
