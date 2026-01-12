package com.learning.patterns.structural.adapter;

/**
 * Standard interface that the client expects to work with.
 * Represents a modern JSON-based analytics service.
 */
public interface AnalyticsLibrary {
    void analyzeData(String jsonData);
}
