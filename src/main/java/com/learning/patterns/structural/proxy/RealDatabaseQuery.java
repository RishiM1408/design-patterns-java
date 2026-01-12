package com.learning.patterns.structural.proxy;

/**
 * Real Subject.
 * The actual object that does the heavy lifting.
 */
public class RealDatabaseQuery implements DatabaseQuery {

    public RealDatabaseQuery() {
        System.out.println("RealDatabaseQuery: Initializing connection (Heavy Process)...");
        try {
            Thread.sleep(1000); // Simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeQuery(String sql) {
        System.out.println("Executing SQL: " + sql);
    }
}
