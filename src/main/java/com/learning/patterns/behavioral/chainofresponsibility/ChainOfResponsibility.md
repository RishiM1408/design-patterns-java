# Chain of Responsibility Pattern

## 🔍 Definition

**Chain of Responsibility** is a behavioral design pattern that lets you pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.

## 🧩 The Problem

You are building an API. Before executing a request, you need to check:

1.  Is the user authenticated?
2.  Is the request rate-limited (throttling)?
3.  Does the user have admin permissions?
4.  Is the data valid?

Putting all this in a single `processRequest()` method is messy. Adding a new check (e.g., "IP Banning") requires modifying the core logic.

## 💡 The Solution

Transform particular behaviors into stand-alone objects called _handlers_. Link these handlers into a chain. Each linked handler has a field for reference to the next handler in the chain. The request travels down the chain until all handlers pass it, or one handler stops it.

## 🏗️ Real-World Analogy

**Tech Support**:

1.  **Level 1 (Bot)**: Can I solve it? No -> Pass to Level 2.
2.  **Level 2 (Human)**: Can I solve it? No -> Pass to Level 3.
3.  **Level 3 (Engineer)**: I solve it.

## 💻 Code Snippet

```java
// Abstract Handler
public abstract class Middleware {
    private Middleware next;

    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    protected boolean checkNext(String email, String password) {
        if (next == null) return true;
        return next.check(email, password);
    }

    public abstract boolean check(String email, String password);
}

// Concrete Handler
public class ThrottlingMiddleware extends Middleware {
    public boolean check(String email, String password) {
        if (requestCount > 5) {
            System.out.println("Throttled!");
            return false; // Break chain
        }
        return checkNext(email, password);
    }
}

// Client
Middleware chain = new ThrottlingMiddleware(2);
chain.linkWith(new AuthMiddleware()).linkWith(new RoleMiddleware());
chain.check("user@example.com", "123");
```

## ✅ Applicability

- Use the pattern when your program is expected to process different kinds of requests in various ways, but the exact types of requests and their sequences are unknown beforehand.
- Use the pattern when it's essential to execute several handlers in a specific order.

## ⚖️ Pros and Cons

| Pros                                           | Cons                                |
| :--------------------------------------------- | :---------------------------------- |
| You can control the order of request handling. | Some requests may end up unhandled. |
| Single Responsibility Principle.               |                                     |
| Open/Closed Principle.                         |                                     |
