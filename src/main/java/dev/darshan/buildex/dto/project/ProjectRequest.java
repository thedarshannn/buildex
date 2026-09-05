package dev.darshan.buildex.dto.project;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(
        @NotBlank String projectName
) {
}
