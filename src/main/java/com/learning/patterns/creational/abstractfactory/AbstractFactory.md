# Abstract Factory Pattern

## 🔍 Definition

**Abstract Factory** is a creational design pattern that lets you produce families of related or dependent objects without specifying their concrete classes.

## 🧩 The Problem

You are building a cloud infrastructure provisioner. You need to create `Instance` (Compute) and `Storage` (Bucket) resources. However, these resources must match: An `AwsInstance` works with `AwsStorage`, but not `GoogleStorage`. You want to prevent the client from mixing them up.

## 💡 The Solution

Define an interface `CloudProviderFactory` that declares creation methods for all distinct products in the family (`createInstance`, `createStorage`). Then, create a separate factory class for each variant (`AwsFactory`, `GoogleFactory`) that implements this interface.

## 🏗️ Real-World Analogy

**Furniture Store**: You buy furniture for your house. If you choose a "Victorian" style, you buy a Victorian Chair and a Victorian Sofa. You don't buy a Modern Sofa with a Victorian Chair. The "Victorian Factory" ensures all pieces you get match that specific style family.

## 💻 Code Snippet

```java
// Abstract Factory
public interface CloudProviderFactory {
    Instance createInstance();
    Storage createStorage();
}

// Concrete Factory
public class AwsFactory implements CloudProviderFactory {
    public Instance createInstance() { return new AwsInstance(); }
    public Storage createStorage() { return new AwsStorage(); }
}

// Client Code
public class Client {
    private Instance instance;
    private Storage storage;

    public Client(CloudProviderFactory factory) {
        instance = factory.createInstance();
        storage = factory.createStorage();
    }
}
```

## ✅ Applicability

- Use the Abstract Factory when your code needs to work with various families of related products, but you don't want it to depend on the concrete classes of those products—they might be unknown beforehand or you simply want to allow for future extensibility.

## ⚖️ Pros and Cons

| Pros                                                                                            | Cons                                                 |
| :---------------------------------------------------------------------------------------------- | :--------------------------------------------------- |
| You can be sure that the products you're getting from a factory are compatible with each other. | The code becomes more complicated than it should be. |
| You avoid tight coupling between concrete products and client code.                             |                                                      |
| Single Responsibility Principle.                                                                |                                                      |
| Open/Closed Principle.                                                                          |                                                      |
