package com.learning.patterns.behavioral.visitor;

/**
 * Concrete Element 1: House.
 */
public class House implements Insurable {
    @Override
    public void accept(InsuranceAgent visitor) {
        visitor.visit(this);
    }
}
