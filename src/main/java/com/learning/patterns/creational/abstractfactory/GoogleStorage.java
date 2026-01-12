package com.learning.patterns.creational.abstractfactory;

/**
 * Concrete Product B2: Google Cloud Storage
 */
public class GoogleStorage implements Storage {
    @Override
    public void allocate(int capacityInGB) {
        System.out.println("Google Cloud Storage bucket created. Capacity: " + capacityInGB + "GB Class: Standard");
    }
}
