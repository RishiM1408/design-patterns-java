package com.learning.patterns.creational.factorymethod;

/**
 * Concrete implementation for SMS notifications.
 */
public class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS notification...");
    }
}
