package com.learning.patterns.behavioral.templatemethod;

/**
 * Concrete Class for PDF.
 */
public class PdfMiner extends DataMiner {
    @Override
    public void extractData() {
        System.out.println("PdfMiner: Extracting text from PDF layers...");
    }

    @Override
    public void parseData() {
        System.out.println("PdfMiner: Parsing PDF text blocks...");
    }
}
