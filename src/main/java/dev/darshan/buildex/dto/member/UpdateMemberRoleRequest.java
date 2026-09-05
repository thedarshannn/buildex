package dev.darshan.buildex.dto.member;

import dev.darshan.buildex.enums.ProjectMemberRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectMemberRole role
) {
}
