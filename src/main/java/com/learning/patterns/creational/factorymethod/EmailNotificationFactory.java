package com.learning.patterns.creational.factorymethod;

/**
 * Concrete Creator for Email.
 */
public class EmailNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
