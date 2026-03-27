package dev.darshan.buildex.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Project {

    Long id;

    String name;

    User owner;

    Boolean isPublic;

    Instant createAt;

    Instant updateAt;

    Instant deletedAt;
}
