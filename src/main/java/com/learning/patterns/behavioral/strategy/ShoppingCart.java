package com.learning.patterns.behavioral.strategy;

/**
 * Context: Shopping Cart.
 * Delegates the payment algorithm to the configured strategy.
 */
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method!");
            return;
        }
        paymentStrategy.pay(amount);
    }
}
