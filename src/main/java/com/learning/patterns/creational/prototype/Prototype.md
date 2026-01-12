# Prototype Pattern

## 🔍 Definition

**Prototype** is a creational design pattern that lets you copy existing objects without making your code dependent on their classes.

## 🧩 The Problem

You have a complex object (e.g., a "Virtual Machine" configuration) that takes a long time to initialize (loading from disk, parsing config). You want to create a second, identical VM. If you create a new one from scratch `new VM()`, it's slow. If you manually copy fields, you depend on private fields and strict class coupling.

## 💡 The Solution

Delegate the cloning process to the actual object that is being cloned. The pattern declares a common interface for all objects that support cloning. Usually, this interface contains just a single method `clone`.

## 🏗️ Real-World Analogy

**Mitotic Cell Division**: Biological cells split to create exact copies of themselves. A cell doesn't "build" a new cell from scratch using raw atoms; it replicates its own DNA and splits. This is an efficient way to create a complex organism (the new cell) based on an existing template (the old cell).

## 💻 Code Snippet

```java
public class LinuxVM implements VMImage {
    public LinuxVM(LinuxVM target) {
        if (target != null) {
            this.osType = target.osType;
            this.software = target.software;
        }
    }

    @Override
    public VMImage clone() {
        return new LinuxVM(this);
    }
}

// Client
LinuxVM master = new LinuxVM("Ubuntu", "Apache"); // Heavy init
LinuxVM worker1 = (LinuxVM) master.clone(); // Fast copy
```

## ✅ Applicability

- Use the pattern when your code shouldn't depend on the concrete classes of objects that you need to copy.
- Use the pattern when you want to reduce the number of subclasses that only differ in the way they initialize their respective objects.
- Use when object creation is expensive (database calls, file I/O) compared to object copying.

## ⚖️ Pros and Cons

| Pros                                                              | Cons                                                                        |
| :---------------------------------------------------------------- | :-------------------------------------------------------------------------- |
| You can clone objects without coupling to their concrete classes. | Cloning complex objects that have circular references might be very tricky. |
| You can get rid of repeated initialization code in your way.      |                                                                             |
| You can produce complex objects more conveniently.                |                                                                             |
