package dev.darshan.buildex.dto.auth;

public record AuthResponse(
        String token,
        UserProfileResponse user
) {

}
