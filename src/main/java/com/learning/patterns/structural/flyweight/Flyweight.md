# Flyweight Pattern

## 🔍 Definition

**Flyweight** is a structural design pattern that lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object.

## 🧩 The Problem

You are making a game with 1,000,000 trees. Each tree has:

- `mesh` (heavy, ~1MB)
- `texture` (heavy, ~2MB)
- `x, y` (light, 8 bytes)

Total RAM: 1M \* 3MB = 3,000 GB (Impossible). Application crashes.

## 💡 The Solution

Separate the **Intrinsic State** (shared, immutable: mesh, texture) from the **Extrinsic State** (unique: x, y).
Create a `TreeType` object (Intrinsic) and a `Tree` object (Extrinsic).
The `Tree` object only holds a reference to `TreeType`.
Now: 1 `TreeType` (3MB) + 1,000,000 `Tree` (8MB) = ~11MB. Huge saving.

## 🏗️ Real-World Analogy

**Library Books**: A library buys 10 copies of "Harry Potter". They don't buy a custom copy for every reader who _might_ borrow it ever.

- **Book Object**: Standard text, cover (Intrinsic).
- **Checkout Record**: Reader Name, Due Date (Extrinsic).

## 💻 Code Snippet

```java
// Flyweight (Intrinsic State)
public class TreeType {
    private String name;
    private String texture; // Heavy
    public void draw(int x, int y) { ... }
}

// Factory (Pool)
public class TreeFactory {
    static Map<String, TreeType> cache = new HashMap<>();
    public static TreeType getTreeType(String name) { ... }
}

// Context (Extrinsic State)
public class Tree {
    private int x, y;
    private TreeType type; // Reference
    public void draw() { type.draw(x, y); }
}
```

## ✅ Applicability

- Use the Flyweight pattern only when your program must support a huge number of objects which barely fit into available RAM.

## ⚖️ Pros and Cons

| Pros                      | Cons                                                                                                                                      |
| :------------------------ | :---------------------------------------------------------------------------------------------------------------------------------------- |
| You can save lots of RAM. | You might be trading RAM over CPU cycles if some of the context data needs to be recalculated each time someone calls a flyweight method. |
|                           | The code becomes much more complicated.                                                                                                   |
