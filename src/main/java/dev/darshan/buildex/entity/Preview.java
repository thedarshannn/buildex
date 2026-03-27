package dev.darshan.buildex.entity;

import dev.darshan.buildex.enums.PreviewStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Preview {

    Long id;

    Project project;

    String nameSpace;

    String podName;

    String previewURL;

    Instant createdAt;

    Instant terminatedAt;

    Instant startedAt;

    PreviewStatus previewStatus;
}

