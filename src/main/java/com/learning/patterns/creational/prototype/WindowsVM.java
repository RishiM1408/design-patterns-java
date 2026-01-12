package com.learning.patterns.creational.prototype;

/**
 * Concrete Prototype for Windows.
 */
public class WindowsVM implements VMImage {
    private String version;
    private boolean antivirusIncluded;

    public WindowsVM(String version, boolean antivirusIncluded) {
        this.version = version;
        this.antivirusIncluded = antivirusIncluded;
        // Heavy init simulated
        System.out.println("Loading Windows VM image...");
    }

    public WindowsVM(WindowsVM target) {
        if (target != null) {
            this.version = target.version;
            this.antivirusIncluded = target.antivirusIncluded;
        }
    }

    @Override
    public VMImage clone() {
        return new WindowsVM(this);
    }

    @Override
    public void start() {
        System.out.println("Starting Windows VM [Ver: " + version + "]");
    }
}
