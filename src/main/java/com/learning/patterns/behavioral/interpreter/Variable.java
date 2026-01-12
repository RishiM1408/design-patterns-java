package com.learning.patterns.behavioral.interpreter;

import java.util.Map;

/**
 * Terminal Expression: Variable.
 */
public class Variable implements Expression {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Map<String, Integer> context) {
        if (context.containsKey(name)) {
            return context.get(name);
        }
        return 0; // Default or error handling
    }
}
