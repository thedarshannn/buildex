package dev.darshan.buildex.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LogInRequest(
        @NotBlank @Email String email,
        @NotBlank @Size(min = 8) String password
) {
}
