# Builder Pattern

## 🔍 Definition

**Builder** is a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.

## 🧩 The Problem

Imagine a complex `DatabaseConfig` object that initializes a connection. It needs `host`, `port`, `username`, `password`, `ssl`, `timeout`, `maxConnections`, etc. Creating a constructor `new DatabaseConfig("localhost", 5432, "admin", null, true, 1000, 10)` is ugly (the "Telescoping Constructor" anti-pattern). It's hard to read and hard to maintain.

## 💡 The Solution

Extract the object construction code out of its own class and move it to a separate objects called _builders_. The builder provides methods like `setPort()`, `setSSL()` that return the builder itself, allowing for method chaining (Fluent Interface).

## 🏗️ Real-World Analogy

**Building a House**: To build a house, you start with a foundation. Then you add walls, windows, doors, and a roof. You might optionally add a swimming pool or a garage. You don't pass all these options into a single "CreateHouse(true, false, true, 4, 2...)" function. You build it step-by-step.

## 💻 Code Snippet

```java
DatabaseConfig config = new DatabaseConfig.Builder("localhost", 5432, "admin")
        .setPassword("secret")
        .setEncrypted(true)
        .setConnectionTimeout(5000)
        .build();
```

## ✅ Applicability

- Use the Builder pattern to get rid of a "telescoping constructor".
- Use the Builder pattern when you want your code to be able to create different representations of some product (e.g., stone house vs wooden house) using the same construction steps (Director).

## ⚖️ Pros and Cons

| Pros                                                                                        | Cons                                                                                                   |
| :------------------------------------------------------------------------------------------ | :----------------------------------------------------------------------------------------------------- |
| You can construct objects step-by-step, defer construction steps or run steps recursively.  | The overall complexity of the code increases since the pattern requires creating multiple new classes. |
| You can reuse the same construction code when building various representations of products. |                                                                                                        |
| Single Responsibility Principle.                                                            |                                                                                                        |
