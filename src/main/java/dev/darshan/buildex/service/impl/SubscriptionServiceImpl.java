package dev.darshan.buildex.service.impl;

import dev.darshan.buildex.dto.Subscription.CheckoutRequest;
import dev.darshan.buildex.dto.Subscription.CheckoutResponse;
import dev.darshan.buildex.dto.Subscription.PortalResponse;
import dev.darshan.buildex.dto.Subscription.SubscriptionResponse;
import dev.darshan.buildex.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {


    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionURL(CheckoutRequest checkoutRequest, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
