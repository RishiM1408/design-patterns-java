package com.learning.patterns.structural.bridge;

/**
 * Client Demo for Bridge Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Bridge Pattern Demo ---");

        // We can mix and match Abstractions and Implementations

        Payment order1 = new OneTimePayment(new StripeGateway());
        order1.makePayment("$50.00");

        System.out.println();

        Payment order2 = new SubscriptionPayment(new PayPalGateway());
        order2.makePayment("$9.99");

        // This flexibility prevents class explosion (StripeSubscription,
        // PayPalSubscription, etc.)
    }
}
