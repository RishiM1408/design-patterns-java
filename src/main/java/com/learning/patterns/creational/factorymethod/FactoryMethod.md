# Factory Method Pattern

## 🔍 Definition

**Factory Method** is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

## 🧩 The Problem

Imagine you are building a notification system. Initially, you only support `Email`. All your code is coupled to the `Email` class. Later, you need to add `SMS`, `Push`, and `Slack`. If you use `new Email()`, you have to modify your core business logic every time a new type is added.

## 💡 The Solution

Replace direct object construction calls with calls to a special factory method. The objects returned by a factory method are often referred to as products.

## 🏗️ Real-World Analogy

**Logistics Management**: A truck delivery company builds a logistics app. It uses `Truck` objects. Later, they add sea logistics (`Ship`). The main `Logistics` class declares a `createTransport()` method. The `RoadLogistics` subclass returns a `Truck`, and the `SeaLogistics` subclass returns a `Ship`. The main app code works with the generic `Transport` interface and doesn't care if it's a truck or ship.

## 💻 Code Snippet

**Structure:**

```java
// Product Interface
public interface Notification {
    void notifyUser();
}

// Concrete Product
public class EmailNotification implements Notification { ... }

// Creator
public abstract class NotificationFactory {
    // The Factory Method
    public abstract Notification createNotification();

    public void sendNotification() {
        // Call the factory method to create a product object.
        Notification n = createNotification();
        // Now, use the product.
        n.notifyUser();
    }
}
```

## ✅ Applicability

- Use the Factory Method when you don't know beforehand the exact types and dependencies of the objects your code should work with.
- Use the Factory Method when you want to provide users of your library or framework with a way to extend its internal components.

## ⚖️ Pros and Cons

| Pros                                                                                                                   | Cons                                                                                                               |
| :--------------------------------------------------------------------------------------------------------------------- | :----------------------------------------------------------------------------------------------------------------- |
| You avoid tight coupling between the creator and the concrete products.                                                | The code may become more complicated since you need to introduce a lot of new subclasses to implement the pattern. |
| Single Responsibility Principle. You can move the product creation code into one place.                                |                                                                                                                    |
| Open/Closed Principle. You can introduce new types of products into the program without breaking existing client code. |                                                                                                                    |
