package com.learning.patterns.creational.abstractfactory;

/**
 * Concrete Factory for Google Cloud Platform.
 */
public class GoogleCloudFactory implements CloudProviderFactory {
    @Override
    public Instance createInstance() {
        return new GoogleInstance();
    }

    @Override
    public Storage createStorage() {
        return new GoogleStorage();
    }
}
