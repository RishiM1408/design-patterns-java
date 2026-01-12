# Bridge Pattern

## 🔍 Definition

**Bridge** is a structural design pattern that lets you split a large class or a set of closely related classes into two separate hierarchies—abstraction and implementation—which can be developed independently.

## 🧩 The Problem

"Cartesian Product" explosion. Imagine you have a `Shape` class (Circle, Square) and trying to subclass them by `Color` (Red, Blue). You get `RedCircle`, `BlueCircle`, `RedSquare`, `BlueSquare`. If you add `Triangle` and `Green`, classes multiply.
In our code example: `Payment` (One-time, Subscription) and `Gateway` (PayPal, Stripe). We don't want `PayPalOneTime`, `StripeOneTime`, `PayPalSubscription`, etc.

## 💡 The Solution

Switch from **Inheritance** to **Composition**.
Extract the `Gateway` specific logic into a separate hierarchy. The `Payment` class holds a reference to a `Gateway`. The `Payment` can delegate the work to the `Gateway` object.

## 🏗️ Real-World Analogy

**Remote Control and TV**: The Remote is the Abstraction (User Interface). The TV is the Implementation (Hardware).

- You can have different Remotes (Basic, Advanced with Voice).
- You can have different TVs (Sony, Samsung).
- Any Remote works with any TV because they bridge via a common signal protocol. You don't need a "SonyRemote" class bound to "SonyTV".

## 💻 Code Snippet

```java
// Implementation
public interface PaymentGateway {
    void processPayment(String amount);
}

// Concrete Implementations
public class PayPalGateway implements PaymentGateway { ... }
public class StripeGateway implements PaymentGateway { ... }

// Abstraction
public abstract class Payment {
    protected PaymentGateway gateway;
    public Payment(PaymentGateway gateway) { this.gateway = gateway; }
    public abstract void makePayment(String amount);
}

// Refined Abstraction
public class SubscriptionPayment extends Payment {
    public SubscriptionPayment(PaymentGateway gateway) { super(gateway); }
    public void makePayment(String amount) {
        gateway.processPayment(amount); // Delegation
        scheduleNextMonth();
    }
}
```

## ✅ Applicability

- Use the Bridge pattern when you want to divide and organize a monolithic class that has several variants of some functionality (e.g., if the class can work with various database servers).
- Use the pattern when you need to extend a class in several orthogonal (independent) dimensions.

## ⚖️ Pros and Cons

| Pros                                                  | Cons                                                                                         |
| :---------------------------------------------------- | :------------------------------------------------------------------------------------------- |
| You can create platform-independent classes and apps. | You might make the code more complicated by applying the pattern to a highly cohesive class. |
| Client code works with high-level abstractions.       |                                                                                              |
| Open/Closed Principle.                                |                                                                                              |
