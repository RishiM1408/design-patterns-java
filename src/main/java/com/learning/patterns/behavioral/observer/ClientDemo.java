package com.learning.patterns.behavioral.observer;

/**
 * Client Demo for Observer Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Observer Pattern Demo ---");

        StockMarket appleStock = new StockMarket();

        Observer user1 = new MobileApp("John");
        Observer user2 = new MobileApp("Jane");
        Observer user3 = new EmailAlert("trader@wallstreet.com");

        appleStock.addObserver(user1);
        appleStock.addObserver(user2);
        appleStock.addObserver(user3);

        System.out.println("\nMarket opens...");
        appleStock.setPrice(99.0f);

        System.out.println("\nMarket rally...");
        appleStock.setPrice(105.50f); // Should trigger EmailAlert
    }
}
