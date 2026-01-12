package com.learning.patterns.structural.composite;

/**
 * The Component Interface.
 * Declares common operations for both simple and complex objects of a
 * composition.
 */
public interface FileSystemComponent {
    void showDetails();

    int getSize(); // in KB
}
