# Composite Pattern

## 🔍 Definition

**Composite** is a structural design pattern that lets you compose objects into tree structures and then work with these structures as if they were individual objects.

## 🧩 The Problem

You have a hierarchical structure, like a File System (Directories contain Files and other Directories). You want to run an operation (e.g., "Get Size") on the whole structure. You don't want to check `if (node instanceof Directory)` every time.

## 💡 The Solution

Create a common interface (`Component`) for both simple Leaves (`File`) and complex Containers (`Directory`).

- **Leaf**: Implements the operation (returns file size).
- **Composite**: Implements the operation by iterating over children and summing their results.

## 🏗️ Real-World Analogy

**Military Structure**: A General sends a command "Attack".

- General -> Colonels (Composite)
- Colonel -> Captains (Composite)
- Captain -> Soldiers (Leaf)
  The General doesn't micromanage every soldier. He just calls `attack()` on his direct subordinates, who delegate it down.

## 💻 Code Snippet

```java
// Component
public interface FileSystemComponent {
    int getSize();
}

// Leaf
public class File implements FileSystemComponent {
    public int getSize() { return this.size; }
}

// Composite
public class Directory implements FileSystemComponent {
    private List<FileSystemComponent> children = new ArrayList<>();

    public int getSize() {
        // Recursion happens here
        return children.stream().mapToInt(FileSystemComponent::getSize).sum();
    }
}
```

## ✅ Applicability

- Use the Composite pattern when you have to implement a tree-like object structure.
- Use the pattern when you want the client code to treat both simple and complex elements uniformly.

## ⚖️ Pros and Cons

| Pros                                                               | Cons                                                                                                  |
| :----------------------------------------------------------------- | :---------------------------------------------------------------------------------------------------- |
| You can work with complex tree structures more conveniently.       | It might be difficult to provide a common interface for classes whose functionality differs too much. |
| Open/Closed Principle. You can introduce new element types easily. |                                                                                                       |
