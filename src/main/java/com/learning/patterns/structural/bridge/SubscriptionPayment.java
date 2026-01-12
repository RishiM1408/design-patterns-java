package com.learning.patterns.structural.bridge;

/**
 * Refined Abstraction: Subscription/Recurring Payment.
 */
public class SubscriptionPayment extends Payment {
    public SubscriptionPayment(PaymentGateway gateway) {
        super(gateway);
    }

    @Override
    public void makePayment(String amount) {
        System.out.println("Setting up Recurring Subscription...");
        gateway.processPayment(amount);
        System.out.println("Next billing scheduled in 30 days.");
    }
}
