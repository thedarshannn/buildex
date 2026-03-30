package dev.darshan.buildex.dto.auth;

public record LogInRequest(
        String email,
        String password
) {
}
