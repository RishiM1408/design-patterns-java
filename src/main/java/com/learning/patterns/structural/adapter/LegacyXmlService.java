package com.learning.patterns.structural.adapter;

/**
 * The Adaptee.
 * A legacy system that processes data in XML format.
 * We cannot change this class (simulated 3rd party or legacy code).
 */
public class LegacyXmlService {
    public void processXmlData(String xmlData) {
        System.out.println("Legacy Service processing XML data: " + xmlData);
    }
}
