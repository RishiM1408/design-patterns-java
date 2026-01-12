package com.learning.patterns.creational.abstractfactory;

/**
 * Concrete Product A1: AWS EC2 Instance
 */
public class AwsInstance implements Instance {
    @Override
    public void start() {
        System.out.println("AWS EC2 Instance started. ID: i-1234567890abcdef0");
    }

    @Override
    public void stop() {
        System.out.println("AWS EC2 Instance stopped.");
    }
}
