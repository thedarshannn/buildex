package dev.darshan.buildex.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plan {

    Long id;

    String name;

    String stripePriceId;

    Integer maxProjects;

    Integer maxTokensPerday;

    Integer maxPreviews;

    Boolean unlimitedAi;

    Boolean active;

}
