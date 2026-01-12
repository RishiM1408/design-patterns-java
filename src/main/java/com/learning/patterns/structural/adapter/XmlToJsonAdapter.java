package com.learning.patterns.structural.adapter;

/**
 * The Adapter.
 * Makes the LegacyXmlService compatible with the AnalyticsLibrary interface.
 * It translates JSON input (from client) to XML (for backend).
 */
public class XmlToJsonAdapter implements AnalyticsLibrary {
    private final LegacyXmlService legacyService;

    public XmlToJsonAdapter(LegacyXmlService legacyService) {
        this.legacyService = legacyService;
    }

    @Override
    public void analyzeData(String jsonData) {
        System.out.println("Adapter: Converting JSON '" + jsonData + "' to XML...");
        // Simple mock conversion logic
        String xmlData = "<data>" + jsonData + "</data>";
        legacyService.processXmlData(xmlData);
    }
}
