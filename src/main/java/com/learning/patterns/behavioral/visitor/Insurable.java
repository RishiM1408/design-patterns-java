package com.learning.patterns.behavioral.visitor;

/**
 * Element Interface.
 * Declares the accept method that takes a visitor.
 */
public interface Insurable {
    void accept(InsuranceAgent visitor);
}
