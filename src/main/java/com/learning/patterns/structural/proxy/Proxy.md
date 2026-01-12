# Proxy Pattern

## 🔍 Definition

**Proxy** is a structural design pattern that lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object.

## 🧩 The Problem

You have a `Database` object. It's wildly resource-intensive to initialize (takes 5 seconds). Not all users need it. Opening it at app startup freezes the UI.
Or, you need to check if the user is `Admin` before allowing a `DELETE` query. You don't want to put security logic inside the raw database driver code.

## 💡 The Solution

Create a `DatabaseProxy`. It implements the same interface as `Database`.

- **Lazy Loading**: The proxy creates the real database object only when `executeQuery()` is called, not before.
- **Access Control**: The proxy checks `if (user.isAdmin)` before passing the call to the real object.

## 🏗️ Real-World Analogy

**Credit Card**: It's a proxy for the cash in your bank account. You don't carry the physical cash bundles (Real Object). You swipe the card (Proxy). The bank checks if you have funds (Access Control) and then moves the money.

## 💻 Code Snippet

```java
public class DatabaseProxy implements Database {
    private RealDatabase realDb;

    public void query(String sql) {
        if (realDb == null) {
            realDb = new RealDatabase(); // Lazy Init
        }
        if (sql.contains("DELETE") && !user.isAdmin()) {
            throw new AccessDeniedException(); // Security
        }
        realDb.query(sql); // Delegation
    }
}
```

## ✅ Applicability

- **Lazy initialization (virtual proxy)**: This is when you have a heavyweight service object that wastes system resources by being always up, even though you only need it from time to time.
- **Access control (protection proxy)**: This is when you want only specific clients to be able to use the service object; for example, when your objects are crucial parts of an operating system and clients are various launched applications (including malicious ones).
- **Logging requests (logging proxy)**: This is when you want to keep a history of requests to the service object.

## ⚖️ Pros and Cons

| Pros                                                                                 | Cons                                                                          |
| :----------------------------------------------------------------------------------- | :---------------------------------------------------------------------------- |
| You can control the service object without clients knowing about it.                 | The code may become more complicated since you need to introduce new classes. |
| You can manage the lifecycle of the service object when clients don't care about it. | The response from the service might get delayed.                              |
| The proxy works even if the service object isn't ready or is not available.          |                                                                               |
