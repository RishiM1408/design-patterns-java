package com.learning.patterns.structural.decorator;

/**
 * Concrete Decorator: Compression.
 * Wraps outgoing data with brackets to simulate "Compression" and unwraps them
 * on read.
 */
public class CompressionDecorator extends DataSourceDecorator {
    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        System.out.println("CompressionDecorator: Compressing data...");
        String compressed = "COMPRESSED(" + data + ")";
        super.writeData(compressed);
    }

    @Override
    public String readData() {
        String data = super.readData();
        System.out.println("CompressionDecorator: Decompressing data...");
        if (data.startsWith("COMPRESSED(") && data.endsWith(")")) {
            return data.substring(11, data.length() - 1);
        }
        return data;
    }
}
