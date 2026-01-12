package com.learning.patterns.creational.abstractfactory;

/**
 * Concrete Product A2: Google Compute Engine
 */
public class GoogleInstance implements Instance {
    @Override
    public void start() {
        System.out.println("Google Compute Engine started. Zone: us-central1-a");
    }

    @Override
    public void stop() {
        System.out.println("Google Compute Engine stopped.");
    }
}
