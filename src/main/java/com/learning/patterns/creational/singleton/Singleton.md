# Singleton Pattern

## 🔍 Definition

**Singleton** is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.

## 🧩 The Problem

The application needs a single, shared configuration manager to handle settings (database URL, API keys) throughout the lifecycle. creating multiple instances would lead to inconsistent states and resource wastage (e.g., re-reading files from disk).

## 💡 The Solution

1.  Make the default constructor `private` to prevent other objects from using `new` with the Singleton class.
2.  Create a `static` creation method that acts as a constructor. Under the hood, this method calls the private constructor to create an object and saves it in a static field. All following calls to this method return the cached object.

## 🏗️ Real-World Analogy

**The Government**: A country can have only one official government. Regardless of the personal identities of the individuals who form the government, the title, "The Government of X", is a global point of access that identifies the group of people in charge.

## 💻 Code Snippet

**Thread-Safe Implementation:**

```java
public class ConfigurationManager {
    private static volatile ConfigurationManager instance;

    private ConfigurationManager() {
        // Load settings...
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }
}
```

## ✅ Applicability

- Use the Singleton pattern when a class in your program should have just a single instance available to all clients; for example, a single database object shared by different parts of the program.
- Use the Singleton pattern when you need stricter control over global variables.

## ⚖️ Pros and Cons

| Pros                                                                             | Cons                                                                                                                                            |
| :------------------------------------------------------------------------------- | :---------------------------------------------------------------------------------------------------------------------------------------------- |
| You can be sure that a class has only a single instance.                         | The Single Responsibility Principle. The pattern solves two problems at the time.                                                               |
| You gain a global access point to that instance.                                 | The pattern requires special treatment in a multithreaded environment.                                                                          |
| The singleton object is initialized only when it's requested for the first time. | It may be difficult to unit test the client code of the Singleton because many test frameworks rely on inheritance when producing mock objects. |
