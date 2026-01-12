package com.learning.patterns.behavioral.visitor;

/**
 * Concrete Element 3: Factory.
 */
public class Factory implements Insurable {
    @Override
    public void accept(InsuranceAgent visitor) {
        visitor.visit(this);
    }
}
