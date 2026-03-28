package dev.darshan.buildex.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsageLog {

    Long id;

    User user;

    Project project;

    String action;

    Integer tokenUsed;

    Integer durationMs;

    String metaData; // json of {model_used, tool_used...}

    Instant createdAt;
}
