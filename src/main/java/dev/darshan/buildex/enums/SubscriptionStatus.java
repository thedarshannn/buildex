package dev.darshan.buildex.enums;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SubscriptionStatus {
    TRIALING("trialing"),
    ACTIVE("active"),
    PAST_DUE("past_due"),
    UNPAID("unpaid"),
    CANCELED("canceled"),
    INCOMPLETE("incomplete"),
    INCOMPLETE_EXPIRED("incomplete_expired"),
    PAUSED("paused");

    private final String stripeValue;
}
