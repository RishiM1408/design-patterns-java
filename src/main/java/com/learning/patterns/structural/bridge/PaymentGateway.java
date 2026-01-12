package com.learning.patterns.structural.bridge;

/**
 * The Implementation Interface.
 * Defines the low-level operations common to all payment gateways.
 */
public interface PaymentGateway {
    void processPayment(String amount);

    void refundPayment(String amount);
}
