package com.learning.patterns.behavioral.iterator;

/**
 * Common interface for all iterators in the application.
 */
public interface ProfileIterator {
    boolean hasNext();

    Profile next();
}
