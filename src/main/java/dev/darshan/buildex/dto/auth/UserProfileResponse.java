package dev.darshan.buildex.dto.auth;

public record UserProfileResponse(
        Long id,
        String email,
        String name,
        String avatarURL
) {
}
