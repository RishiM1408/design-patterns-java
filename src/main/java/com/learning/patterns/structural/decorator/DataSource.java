package com.learning.patterns.structural.decorator;

/**
 * Component Interface.
 * Defines operations that can be altered by decorators.
 */
public interface DataSource {
    void writeData(String data);

    String readData();
}
