package dev.darshan.buildex.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    Long id;

    String email;

    String passwordHash;

    String name;

    String avatarUrl;

    Instant createAt;

    Instant updateAt;

    Instant deletedAt;


}
