package com.learning.patterns.behavioral.interpreter;

import java.util.Map;

/**
 * Terminal Expression: Number.
 */
public class Number implements Expression {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Map<String, Integer> context) {
        return number;
    }
}
