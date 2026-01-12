package com.learning.patterns.creational.factorymethod;

/**
 * Client Demo for Factory Method Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Factory Method Pattern Demo ---");

        // Scenario: Determines strategy at runtime (simulation)
        NotificationFactory factory;

        // User chooses Email
        factory = new EmailNotificationFactory();
        factory.sendNotification();

        // User chooses SMS
        factory = new SMSNotificationFactory();
        factory.sendNotification();
    }
}
