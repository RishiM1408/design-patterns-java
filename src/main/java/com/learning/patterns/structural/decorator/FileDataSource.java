package com.learning.patterns.structural.decorator;

/**
 * Concrete Component.
 * The basic object that provides default behavior (e.g., File I/O).
 */
public class FileDataSource implements DataSource {
    private String filename;
    // Simulating file storage in memory for demo purposes
    private String simulatedFileContent = "";

    public FileDataSource(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeData(String data) {
        System.out.println("Writing to file (" + filename + "): " + data);
        this.simulatedFileContent = data;
    }

    @Override
    public String readData() {
        System.out.println("Reading from file (" + filename + "): " + simulatedFileContent);
        return simulatedFileContent;
    }
}
