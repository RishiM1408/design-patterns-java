package com.learning.patterns.behavioral.visitor;

/**
 * Concrete Element 2: Car.
 */
public class Car implements Insurable {
    @Override
    public void accept(InsuranceAgent visitor) {
        visitor.visit(this);
    }
}
