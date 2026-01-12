package com.learning.patterns.creational.prototype;

/**
 * Concrete Prototype.
 * Represents a specific VM configuration (e.g., Linux Web Server).
 * Using sleep to simulate expensive creation time.
 */
public class LinuxVM implements VMImage {
    private String osType;
    private String softwareBundle;
    private String securityGroup;

    public LinuxVM(String osType, String softwareBundle, String securityGroup) {
        this.osType = osType;
        this.softwareBundle = softwareBundle;
        this.securityGroup = securityGroup;
        loadFromDisk(); // Simulate heavy operation
    }

    private void loadFromDisk() {
        try {
            System.out.println("Loading Linux VM image from disk (heavy op)...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Constructor for cloning (copying state)
    // Protected to ensure only clone method uses it if desired.
    public LinuxVM(LinuxVM target) {
        if (target != null) {
            this.osType = target.osType;
            this.softwareBundle = target.softwareBundle;
            this.securityGroup = target.securityGroup;
        }
    }

    @Override
    public VMImage clone() {
        // Here we use a copy constructor or manual field copying
        return new LinuxVM(this);
    }

    @Override
    public void start() {
        System.out.println("Starting VM [OS: " + osType + ", Software: " + softwareBundle + "]");
    }

    @Override
    public String toString() {
        return "LinuxVM{osType='" + osType + "', softwareBundle='" + softwareBundle + "', security='" + securityGroup
                + "'}";
    }
}
