package com.learning.patterns.behavioral.templatemethod;

/**
 * Client Demo for Template Method pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Template Method Pattern Demo ---");

        System.out.println("\nMining PDF:");
        DataMiner pdfMiner = new PdfMiner();
        pdfMiner.mine("annual_report.pdf");

        System.out.println("\nMining CSV:");
        DataMiner csvMiner = new CsvMiner();
        csvMiner.mine("data.csv");

        // Both used the same high-level algorithm structure (open -> extract -> parse
        // -> close)
    }
}
