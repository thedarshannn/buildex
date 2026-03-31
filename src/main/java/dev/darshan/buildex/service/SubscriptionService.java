package dev.darshan.buildex.service;

import dev.darshan.buildex.dto.Subscription.CheckoutRequest;
import dev.darshan.buildex.dto.Subscription.CheckoutResponse;
import dev.darshan.buildex.dto.Subscription.PortalResponse;
import dev.darshan.buildex.dto.Subscription.SubscriptionResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckoutSessionURL(CheckoutRequest checkoutRequest, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}
