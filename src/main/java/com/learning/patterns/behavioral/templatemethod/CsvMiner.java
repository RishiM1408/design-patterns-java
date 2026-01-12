package com.learning.patterns.behavioral.templatemethod;

/**
 * Concrete Class for CSV.
 */
public class CsvMiner extends DataMiner {
    @Override
    public void extractData() {
        System.out.println("CsvMiner: Reading lines from CSV...");
    }

    @Override
    public void parseData() {
        System.out.println("CsvMiner: Splitting by comma delimiter...");
    }
}
