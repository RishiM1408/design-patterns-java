# Strategy Pattern

## 🔍 Definition

**Strategy** is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

## 🧩 The Problem

"Navigator App".
Version 1: Only "Road" routes. Code is simple.
Version 2: Add "Walking". Code gets a big `if-else`.
Version 3: Add "Public Transport".
Version 4: Add "Cycling".
The `RouteBuilder` class is now huge, complex, and unmaintainable.

## 💡 The Solution

Extract each routing algorithm into its own class (`RoadStrategy`, `WalkStrategy`).
The Context (`Navigator`) holds a reference to a generic `RouteStrategy`.
The Client configures the Navigator with the desired Strategy instance.

## 🏗️ Real-World Analogy

**Getting to the Airport**:

- **Strategy 1**: Take a taxi (Expensive, Fast).
- **Strategy 2**: Take a bus (Cheap, Slow).
- **Strategy 3**: Drive yourself (Medium cost, Risk of parking).
  You (Context) choose a "Transportation Strategy" based on your budget/time constraints. The goal (Airport) is the same.

## 💻 Code Snippet

```java
public interface PaymentStrategy {
    void pay(int amount);
}

public class CreditCardStrategy implements PaymentStrategy {
    public void pay(int amount) { System.out.println("Paid " + amount + " via Card"); }
}

public class PayPalStrategy implements PaymentStrategy {
    public void pay(int amount) { System.out.println("Paid " + amount + " via PayPal"); }
}

public class ShoppingCart {
    public void checkout(int amount, PaymentStrategy strategy) {
        strategy.pay(amount);
    }
}
```

## ✅ Applicability

- Use the Strategy pattern when you want to use different variants of an algorithm within an object and be able to switch from one algorithm to another during runtime.
- Use the Strategy when you have a lot of similar classes that only differ in the way they execute some behavior.

## ⚖️ Pros and Cons

| Pros                                                                                   | Cons                                                                                                                                                                             |
| :------------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| You can swap algorithms used inside an object at runtime.                              | If you only have a couple of algorithms and they rarely change, there's no real reason to overcomplicate the program with new classes and interfaces that come with the pattern. |
| You can isolate the implementation details of an algorithm from the code that uses it. | Clients must be aware of the differences between strategies to be able to select a proper one.                                                                                   |
| Open/Closed Principle.                                                                 |                                                                                                                                                                                  |
