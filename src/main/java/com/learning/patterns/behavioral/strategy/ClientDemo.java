package com.learning.patterns.behavioral.strategy;

/**
 * Client Demo for Strategy Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Strategy Pattern Demo ---");

        ShoppingCart cart = new ShoppingCart();
        int totalAmount = 500;

        // User chooses PayPal
        cart.setPaymentStrategy(new PayPalStrategy("myemail@example.com", "mypwd"));
        cart.checkout(totalAmount);

        // User changes mind to Credit Card
        cart.setPaymentStrategy(new CreditCardStrategy("Rishi M", "1234567890123456", "786", "12/28"));
        cart.checkout(totalAmount);
    }
}
