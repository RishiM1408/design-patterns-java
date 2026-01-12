package com.learning.patterns.structural.bridge;

/**
 * Concrete Implementation: Stripe.
 */
public class StripeGateway implements PaymentGateway {
    @Override
    public void processPayment(String amount) {
        System.out.println("Stripe: Charged " + amount + " on Credit Card ending 4242.");
    }

    @Override
    public void refundPayment(String amount) {
        System.out.println("Stripe: Refunded " + amount + " to original payment source.");
    }
}
