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

    Integer maxPreviews; // Maximum number of previews allowed per plan.

    Boolean unlimitedAi; // Unlimited access to LLMs, ignore the maxTokensPerday if true.

    Boolean active;

}
