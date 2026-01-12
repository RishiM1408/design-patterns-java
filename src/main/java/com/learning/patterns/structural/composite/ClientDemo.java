package com.learning.patterns.structural.composite;

/**
 * Client Demo for Composite Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Composite Pattern Demo ---");

        // Use Case: Calculating size of nested directories

        // Leaf nodes
        File file1 = new File("resume.pdf", 500);
        File file2 = new File("photo.png", 2000);
        File file3 = new File("settings.ini", 10);

        // Sub-directory
        Directory images = new Directory("images");
        images.addComponent(file2);

        // Root directory
        Directory root = new Directory("root");
        root.addComponent(file1);
        root.addComponent(file3);
        root.addComponent(images); // Nesting

        // Client treats the whole tree as a single object
        System.out.println("File System Structure:");
        root.showDetails();

        System.out.println("\nTotal Size of 'root': " + root.getSize() + " KB");
    }
}
