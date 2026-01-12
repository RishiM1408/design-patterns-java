package com.learning.patterns.structural.adapter;

/**
 * Client Demo for Adapter Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Adapter Pattern Demo ---");

        // Client wants to simply analyze JSON
        String jsonInput = "{\"user\": \"admin\"}";

        // But we have a legacy service
        LegacyXmlService legacyService = new LegacyXmlService();

        // So we wrap it in an adapter
        AnalyticsLibrary adapter = new XmlToJsonAdapter(legacyService);

        // Client code works happily with the target interface
        adapter.analyzeData(jsonInput);
    }
}
