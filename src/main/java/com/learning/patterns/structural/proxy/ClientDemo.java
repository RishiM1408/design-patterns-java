package com.learning.patterns.structural.proxy;

/**
 * Client Demo for Proxy Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Proxy Pattern Demo ---");

        System.out.println("\n1. Guest User attempting dangerous operation:");
        DatabaseQuery guestQuery = new DatabaseProxy(false);
        guestQuery.executeQuery("SELECT * FROM users");
        guestQuery.executeQuery("DELETE FROM users"); // Should be blocked

        System.out.println("\n2. Admin User executing operations:");
        DatabaseQuery adminQuery = new DatabaseProxy(true);
        // Object initializes only on first valid call
        adminQuery.executeQuery("DELETE FROM users");

        System.out.println("Note: RealDatabaseQuery was only initialized when needed by Admin.");
    }
}
