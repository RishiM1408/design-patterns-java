package com.learning.patterns.creational.singleton;

/**
 * Client Demo for Singleton Pattern.
 * Demonstrates that multiple calls to getInstance() return the same object.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Singleton Pattern Demo ---");

        // thread 1
        Thread t1 = new Thread(() -> {
            ConfigurationManager config1 = ConfigurationManager.getInstance();
            System.out.println("Thread 1: Host = " + config1.getProperty("db.host"));
            System.out.println("Thread 1: HashCode = " + config1.hashCode());
        });

        // thread 2
        Thread t2 = new Thread(() -> {
            ConfigurationManager config2 = ConfigurationManager.getInstance();
            System.out.println("Thread 2: Host = " + config2.getProperty("db.host"));
            System.out.println("Thread 2: HashCode = " + config2.hashCode());
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
