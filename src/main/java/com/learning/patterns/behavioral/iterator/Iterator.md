# Iterator Pattern

## 🔍 Definition

**Iterator** is a behavioral design pattern that lets you traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.).

## 🧩 The Problem

You have a collection (e.g., `SocialNetwork`). Internally, it might use an Array, a Linked List, or a complex Graph.
You want clients to be able to loop through "Friends" or "Co-workers".
If you expose the internal structure (`List<Profile>`), you can never change it later without breaking client code. Also, complex traversals (Graph DFS/BFS) shouldn't be in the client logic.

## 💡 The Solution

Extract the traversal behavior into a separate object called an **Iterator**. This object encapsulates the traversal details (current position, how to get next). The collection provides a method `createIterator()`.

## 🏗️ Real-World Analogy

**Sightseeing**: You are in a massive city (The Collection).

1.  **Random Walk**: You wander aimlessly (Direct Access).
2.  **Guidebook/Tour Guide**: You follow a specific route (Iterator). The guide knows the optimized path. You just follow "next step".

## 💻 Code Snippet

```java
// Iterator Interface
public interface ProfileIterator {
    boolean hasNext();
    Profile next();
}

// Concrete Iterator
public class FacebookIterator implements ProfileIterator {
    private Facebook facebook;
    private int currentPosition = 0;

    public boolean hasNext() { ... }
    public Profile next() { ... }
}

// Collection
public class Facebook implements SocialNetwork {
    public ProfileIterator createFriendsIterator(String email) {
        return new FacebookIterator(this, "friends", email);
    }
}
```

## ✅ Applicability

- Use the pattern when your collection has a complex data structure under the hood, but you want to hide its complexity from clients.
- Use the pattern to reduce duplication of traversal code across your app.

## ⚖️ Pros and Cons

| Pros                                                                             | Cons                                                           |
| :------------------------------------------------------------------------------- | :------------------------------------------------------------- |
| Single Responsibility Principle. Algorithms are separated from collections.      | Applying the pattern to simple collections can be an overkill. |
| Open/Closed Principle. You can implement new types of collections and iterators. |                                                                |
| You can iterate over the same collection in parallel.                            |                                                                |
