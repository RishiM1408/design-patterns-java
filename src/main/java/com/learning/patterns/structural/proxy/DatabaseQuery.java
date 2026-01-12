package com.learning.patterns.structural.proxy;

/**
 * Subject Interface.
 * Defines the common methods for RealSubject and Proxy.
 */
public interface DatabaseQuery {
    void executeQuery(String sql);
}
