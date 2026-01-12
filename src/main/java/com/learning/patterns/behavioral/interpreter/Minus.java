package com.learning.patterns.behavioral.interpreter;

import java.util.Map;

/**
 * Non-Terminal Expression: Minus.
 */
public class Minus implements Expression {
    private Expression left;
    private Expression right;

    public Minus(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Map<String, Integer> context) {
        return left.interpret(context) - right.interpret(context);
    }
}
