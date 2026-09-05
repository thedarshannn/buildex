package dev.darshan.buildex.dto.member;

import dev.darshan.buildex.enums.ProjectMemberRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequest(
        @Email @NotBlank String email,
        @NotNull ProjectMemberRole role
) {
}
