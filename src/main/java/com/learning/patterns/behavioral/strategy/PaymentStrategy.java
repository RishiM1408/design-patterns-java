package com.learning.patterns.behavioral.strategy;

/**
 * Strategy Interface.
 * Defines the common algorithm for all payment strategies.
 */
public interface PaymentStrategy {
    void pay(int amount);
}
