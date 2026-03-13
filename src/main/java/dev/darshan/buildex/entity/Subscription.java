package dev.darshan.buildex.entity;

import dev.darshan.buildex.enums.SubscriptionStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscription {

    Long id;

    User user;

    Plan plan;

    String stripeCustomerId;

    String stripeSubscriptionId;

    SubscriptionStatus status;

    Instant currentPeriodStart;

    Instant currentPeriodEnd;

    Boolean cancelAtPeriodEnd;

    Instant createdAt;

    Instant updatedAt;
}
