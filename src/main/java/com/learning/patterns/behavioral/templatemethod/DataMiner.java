package com.learning.patterns.behavioral.templatemethod;

/**
 * Abstract Class.
 * Defines the template method (mine) and the skeleton of the algorithm.
 */
public abstract class DataMiner {

    /**
     * The Template Method.
     * Declared final so subclasses can't override the structure.
     */
    public final void mine(String path) {
        openFile(path);
        extractData();
        parseData();
        analyzeData();
        sendReport();
        closeFile();
    }

    // Standard steps
    public void openFile(String path) {
        System.out.println("DataMiner: Opening file " + path);
    }

    public void kAnalyzeData() { // Optional hook?
        // Renamed to avoid confusion with abstract method
    }

    public void analyzeData() {
        System.out.println("DataMiner: Analyzing raw data entity...");
    }

    public void sendReport() {
        System.out.println("DataMiner: Sending analysis report...");
    }

    public void closeFile() {
        System.out.println("DataMiner: Closing file.");
    }

    // Steps to be implemented by subclasses
    public abstract void extractData();

    public abstract void parseData();
}
