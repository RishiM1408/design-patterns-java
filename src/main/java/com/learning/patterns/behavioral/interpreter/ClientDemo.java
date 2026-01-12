package com.learning.patterns.behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * Client Demo for Interpreter Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Interpreter Pattern Demo ---");

        // Expression: w + x - z
        // Context: w=5, x=10, z=42

        String expression = "w + x - z";
        Map<String, Integer> context = new HashMap<>();
        context.put("w", 5);
        context.put("x", 10);
        context.put("z", 42);

        // Building the syntax tree manually (Parser would typically do this)
        // Tree: Minus(Plus(w, x), z)
        Expression syntaxTree = new Minus(
                new Plus(new Variable("w"), new Variable("x")),
                new Variable("z"));

        int result = syntaxTree.interpret(context);
        System.out.println("Expression: " + expression);
        System.out.println("Result: " + result); // (5 + 10) - 42 = -27
    }
}
