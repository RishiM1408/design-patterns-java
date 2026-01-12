package com.learning.patterns.creational.factorymethod;

/**
 * Abstract Creator.
 * Declares the factory method that returns a Notification object.
 * The core logic (sendNotification) uses the product, but doesn't know the
 * concrete type.
 */
public abstract class NotificationFactory {

    /**
     * The Factory Method.
     * Subclasses must implement this to create the specific product.
     */
    public abstract Notification createNotification();

    /**
     * Core business logic that uses the factory method.
     */
    public void sendNotification() {
        Notification notification = createNotification();
        notification.notifyUser();
    }
}
