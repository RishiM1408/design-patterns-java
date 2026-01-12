package com.learning.patterns.structural.bridge;

/**
 * Refined Abstraction: One-Time Payment.
 */
public class OneTimePayment extends Payment {
    public OneTimePayment(PaymentGateway gateway) {
        super(gateway);
    }

    @Override
    public void makePayment(String amount) {
        System.out.println("Processing One-Time Payment...");
        gateway.processPayment(amount);
    }
}
