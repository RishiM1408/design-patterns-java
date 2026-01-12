# Decorator Pattern

## 🔍 Definition

**Decorator** is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.

## 🧩 The Problem

You have a `FileStream` class that reads/writes data. You want to add "Encryption". Then "Compression". Then "Caching".
Inheritance fails: `EncryptedFileStream`, `CompressedFileStream`, `EncryptedCompressedFileStream`... explicit class explosion.

## 💡 The Solution

Use **Composition** (Wrappers).
Create `EncryptionDecorator` and `CompressionDecorator`. Both realize the same interface as `FileStream`. The decorators delegate the main work to the wrapped object but add their own behavior before or after.

## 🏗️ Real-World Analogy

**Wearing Clothes**: You (the object) are cold.

1.  Put on a **Sweater** (Decorator). Now you are "You + Warmth".
2.  Put on a **Raincoat** (Decorator). Now you are "You + Warmth + Dry".
    You didn't evolve into a new species `ManWithCoat`. You just wrapped yourself. You can take them off in any order.

## 💻 Code Snippet

```java
// Component
public interface DataSource {
    void write(String data);
}

// Concrete Component
public class FileDataSource implements DataSource { ... }

// Decorator
public class EncryptionDecorator implements DataSource {
    private DataSource wrappee;

    public void write(String data) {
        String encrypted = encrypt(data); // Added behavior
        wrappee.write(encrypted); // Delegation
    }
}

// Client
DataSource source = new CompressionDecorator(
                        new EncryptionDecorator(
                            new FileDataSource("out.dat")));
source.write("salary_data");
```

## ✅ Applicability

- Use the Decorator pattern when you need to be able to assign extra behaviors to objects at runtime without breaking the code that uses these objects.
- Use the pattern when it's awkward or impossible to extend an object's behavior using inheritance.

## ⚖️ Pros and Cons

| Pros                                                               | Cons                                                                                                                    |
| :----------------------------------------------------------------- | :---------------------------------------------------------------------------------------------------------------------- |
| You can extend an object's behavior without making a new subclass. | It's hard to remove a specific wrapper from the wrappers stack.                                                         |
| You can add or remove responsibilities from an object at runtime.  | It's hard to implement a decorator in such a way that its behavior doesn't depend on the order in the decorators stack. |
| Single Responsibility Principle.                                   | The initial configuration code of layers might look ugly.                                                               |
