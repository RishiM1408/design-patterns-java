package com.learning.patterns.creational.abstractfactory;

/**
 * Concrete Product B1: AWS S3 Storage
 */
public class AwsStorage implements Storage {
    @Override
    public void allocate(int capacityInGB) {
        System.out.println("AWS S3 Bucket allocated with " + capacityInGB + "GB standard storage.");
    }
}
