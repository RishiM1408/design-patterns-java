package com.learning.patterns.creational.abstractfactory;

/**
 * Abstract Factory Interface.
 * Defines methods to create a family of related objects (Instance + Storage).
 */
public interface CloudProviderFactory {
    Instance createInstance();

    Storage createStorage();
}
