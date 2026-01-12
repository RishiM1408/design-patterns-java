package com.learning.patterns.creational.factorymethod;

/**
 * Concrete Creator for SMS.
 */
public class SMSNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
