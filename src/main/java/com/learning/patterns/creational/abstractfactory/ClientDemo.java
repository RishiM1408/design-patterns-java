package com.learning.patterns.creational.abstractfactory;

/**
 * Client Demo for Abstract Factory Pattern.
 */
public class ClientDemo {

    /**
     * The client code works with factories and products only through abstract
     * types:
     * CloudProviderFactory, Instance, and Storage.
     */
    private static void provisionInfrastructure(CloudProviderFactory factory) {
        Instance instance = factory.createInstance();
        Storage storage = factory.createStorage();

        instance.start();
        storage.allocate(500);
        instance.stop();
    }

    public static void main(String[] args) {
        System.out.println("--- Abstract Factory Pattern Demo ---");

        System.out.println("Provisioning AWS Environment:");
        provisionInfrastructure(new AwsFactory());

        System.out.println("\nProvisioning Google Cloud Environment:");
        provisionInfrastructure(new GoogleCloudFactory());
    }
}
