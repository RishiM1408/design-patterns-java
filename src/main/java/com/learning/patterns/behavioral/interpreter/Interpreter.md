# Interpreter Pattern

## 🔍 Definition

**Interpreter** is a behavioral design pattern that provides a way to evaluate language grammar or expressions.

## 🧩 The Problem

Your application uses a specific language or notation that you need to interpret (e.g., SQL, Regular Expressions, Math Strings like "5 + (10 - 2)"). Parsing this with string manipulation tools is error-prone, hard to scale, and hard to maintain.

## 💡 The Solution

Represent each grammar rule (Number, Plus, Minus) as a separate class implementing a common `interpret()` interface. Build a syntax tree (AST) where complex expressions (`Plus`) contain simpler expressions (`Number`).

## 🏗️ Real-World Analogy

**Sheet Music**: A musician is an interpreter. The sheet music uses a specific language (notes, rests, clefs). The musician reads these symbols and interprets them into sounds.

## 💻 Code Snippet

```java
public interface Expression {
    int interpret();
}

public class Number implements Expression {
    private int n;
    public Number(int n) { this.n = n; }
    public int interpret() { return n; }
}

public class Add implements Expression {
    private Expression left, right;
    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

// Client parses "5 + 10" into:
Expression e = new Add(new Number(5), new Number(10));
System.out.println(e.interpret()); // 15
```

## ✅ Applicability

- Use the Interpreter pattern when your domain has a simple grammar that you need to evaluate frequently.
- Not recommended for complex languages (use a real parser generator like ANTLR instead).

## ⚖️ Pros and Cons

| Pros                                         | Cons                                      |
| :------------------------------------------- | :---------------------------------------- |
| It's easy to change and extend the grammar.  | Complex grammars become hard to maintain. |
| Implementing the grammar is straightforward. |                                           |
