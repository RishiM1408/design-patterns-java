package com.learning.patterns.behavioral.interpreter;

import java.util.Map;

/**
 * Abstract Expression.
 */
public interface Expression {
    int interpret(Map<String, Integer> context);
}
