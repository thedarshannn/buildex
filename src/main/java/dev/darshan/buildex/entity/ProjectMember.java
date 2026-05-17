package dev.darshan.buildex.entity;

import dev.darshan.buildex.enums.ProjectMemberRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "project_members")
public class ProjectMember {

    @EmbeddedId
    ProjectMemberId projectMemberId;

    @ManyToOne
    @MapsId("projectId")
    Project project;

    @ManyToOne
    @MapsId("userId")
    User user;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ProjectMemberRole memberRole;

    Instant invitedAt;

    Instant acceptedAt;

}
