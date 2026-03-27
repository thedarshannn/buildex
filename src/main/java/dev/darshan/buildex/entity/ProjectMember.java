package dev.darshan.buildex.entity;

import dev.darshan.buildex.enums.ProjectMemberRole;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectMember {

    ProjectMemberId projectMemberId;

    Project project;

    User invitedBy;

    ProjectMemberRole memberRole;

    Instant invitedAt;

    Instant acceptedAt;

}
