package com.learning.patterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Client Demo for Visitor Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Visitor Pattern Demo ---");

        List<Insurable> assets = new ArrayList<>();
        assets.add(new House());
        assets.add(new Car());
        assets.add(new Factory());

        // We want to perform an operation (Print Quote) on all these diverse objects
        // without modifying their classes.
        InsuranceAgent agent = new QuotePrinter();

        for (Insurable asset : assets) {
            asset.accept(agent);
        }
    }
}
