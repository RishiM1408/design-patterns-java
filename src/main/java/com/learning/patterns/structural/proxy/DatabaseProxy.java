package com.learning.patterns.structural.proxy;

/**
 * The Proxy.
 * Controls access to the RealDatabaseQuery.
 * Implements Lazy Initialization and Access Control (optional).
 */
public class DatabaseProxy implements DatabaseQuery {
    private RealDatabaseQuery realQuery;
    private boolean isAdmin;

    public DatabaseProxy(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public void executeQuery(String sql) {
        if (!isAdmin && (sql.startsWith("DELETE") || sql.startsWith("DROP"))) {
            System.out.println("DatabaseProxy: Access Denied. Only Admins can DELETE/DROP.");
            return;
        }

        if (realQuery == null) {
            System.out.println("DatabaseProxy: Lazy loading RealDatabaseQuery...");
            realQuery = new RealDatabaseQuery();
        }

        realQuery.executeQuery(sql);
    }
}
