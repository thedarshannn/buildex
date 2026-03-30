package dev.darshan.buildex.dto.auth;

public record SignUpRequest(
        String email,
        String name,
        String password
) {

}
