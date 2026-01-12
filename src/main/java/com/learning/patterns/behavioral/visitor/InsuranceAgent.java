package com.learning.patterns.behavioral.visitor;

/**
 * Visitor Interface.
 * Declares a visit method for each concrete element class.
 */
public interface InsuranceAgent {
    void visit(House house);

    void visit(Car car);

    void visit(Factory factory);
}
