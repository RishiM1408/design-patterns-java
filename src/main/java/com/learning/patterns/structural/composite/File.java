package com.learning.patterns.structural.composite;

/**
 * The Leaf.
 * Represents end objects. A Leaf can't have any children.
 */
public class File implements FileSystemComponent {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("  File: " + name + " (" + size + "KB)");
    }

    @Override
    public int getSize() {
        return size;
    }
}
