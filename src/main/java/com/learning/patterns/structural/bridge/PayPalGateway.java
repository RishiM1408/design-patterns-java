package com.learning.patterns.structural.bridge;

/**
 * Concrete Implementation: PayPal.
 */
public class PayPalGateway implements PaymentGateway {
    @Override
    public void processPayment(String amount) {
        System.out.println("PayPal: Processed payment of " + amount + " via API v2.");
    }

    @Override
    public void refundPayment(String amount) {
        System.out.println("PayPal: Refunded " + amount + " to user wallet.");
    }
}
