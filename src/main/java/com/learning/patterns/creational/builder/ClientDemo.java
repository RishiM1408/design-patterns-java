package com.learning.patterns.creational.builder;

/**
 * Client Demo for Builder Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Builder Pattern Demo ---");

        // Building a standard configuration
        DatabaseConfig standardConfig = new DatabaseConfig.Builder("localhost", 5432, "admin")
                .setPassword("secret")
                .build();

        System.out.println("Standard Config: " + standardConfig);

        // Building a secure, high-performance configuration
        DatabaseConfig secureConfig = new DatabaseConfig.Builder("db.prod.server", 5432, "root")
                .setPassword("super_secure")
                .setEncrypted(true)
                .setMaxConnections(100)
                .setConnectionTimeout(10000)
                .build();

        System.out.println("Secure Config: " + secureConfig);
    }
}
