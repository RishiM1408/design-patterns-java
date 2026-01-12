package com.learning.patterns.creational.prototype;

/**
 * Prototype Interface.
 * Declares the clone method.
 * We extend Java's Cloneable interface, but strictly define the return type
 * to be specific to our domain if needed, or stick to standard practice.
 */
public interface VMImage extends Cloneable {
    VMImage clone();

    void start();
}
