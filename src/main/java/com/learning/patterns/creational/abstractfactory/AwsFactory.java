package com.learning.patterns.creational.abstractfactory;

/**
 * Concrete Factory for AWS.
 */
public class AwsFactory implements CloudProviderFactory {
    @Override
    public Instance createInstance() {
        return new AwsInstance();
    }

    @Override
    public Storage createStorage() {
        return new AwsStorage();
    }
}
