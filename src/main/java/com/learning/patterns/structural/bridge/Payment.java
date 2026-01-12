package com.learning.patterns.structural.bridge;

/**
 * The Abstraction.
 * Defines the high-level control logic for payments.
 * It maintains a reference to an object of type Implementation
 * (PaymentGateway).
 */
public abstract class Payment {
    protected PaymentGateway gateway;

    public Payment(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public abstract void makePayment(String amount);
}
