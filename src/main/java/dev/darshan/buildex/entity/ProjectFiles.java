package dev.darshan.buildex.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectFiles {

    Long id;

    Project project;

    String path;

    String minioObjectKey;

    User createdBy;

    User updatedBy;

    Instant createdAt;

    Instant updatedAt;

    Instant deletedAt;
}
