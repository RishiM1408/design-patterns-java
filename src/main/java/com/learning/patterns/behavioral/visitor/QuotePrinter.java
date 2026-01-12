package com.learning.patterns.behavioral.visitor;

/**
 * Concrete Visitor: QuotePrinter.
 * Calculates insurance quotes for different elements.
 */
public class QuotePrinter implements InsuranceAgent {
    @Override
    public void visit(House house) {
        System.out.println("Quote for House: $500/year (Fire+Theft)");
    }

    @Override
    public void visit(Car car) {
        System.out.println("Quote for Car: $1000/year (Comprehensive)");
    }

    @Override
    public void visit(Factory factory) {
        System.out.println("Quote for Factory: $50,000/year (Liability+Damage)");
    }
}
