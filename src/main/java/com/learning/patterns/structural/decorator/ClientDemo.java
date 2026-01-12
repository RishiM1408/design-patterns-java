package com.learning.patterns.structural.decorator;

/**
 * Client Demo for Decorator Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Decorator Pattern Demo ---");

        String sensitiveData = "SalaryRecords_2024";

        // stack decorators: File <- Encryption <- Compression
        DataSource source = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("salary.db")));

        System.out.println("Writing Data:");
        source.writeData(sensitiveData);
        // The file holds: COMPRESSED(Base64(SalaryRecords_2024))

        System.out.println("\nReading Data:");
        String result = source.readData();

        System.out.println("Result: " + result);
    }
}
