# Visitor Pattern

## 🔍 Definition

**Visitor** is a behavioral design pattern that lets you separate algorithms from the objects on which they operate. It allows you to add new operations to existing object structures without modifying the structures.

## 🧩 The Problem

You have a set of Geographic nodes: `City`, `Industry`, `Park`.
The graph is huge and stable.
Suddenly, you need to "Export to XML". Then "Export to JSON". Then "Calculate Pollution Score".
Modifying `City`, `Industry`, `Park` every week to add these methods violates OCP and bloats the classes.

## 💡 The Solution

Create a separate interface `Visitor` with methods: `visitCity(c)`, `visitIndustry(i)`.
The Node classes only add one method: `accept(Visitor v) { v.visit(this); }`.
Now, to add "XML Export", you create `XmlVisitor`. To add "JSON", `JsonVisitor`. The Node classes are never touched again.

## 🏗️ Real-World Analogy

**Insurance Agent**: The Agent (Visitor) visits different buildings:

- Visits a **Home**: "Check smoke detectors."
- Visits a **Factory**: "Check fire extinguishers."
- Visits a **Bank**: "Check theft alarms."
  The buildings don't know _how_ to insure themselves; they just "accept" the agent, who performs the specific logic for that type of building.

## 💻 Code Snippet

```java
// Logic moved to this class
public interface Visitor {
    void visit(Book book);
    void visit(Fruit fruit);
}

// Elements simply "accept"
public interface Item {
    void accept(Visitor v);
}

public class Book implements Item {
    public void accept(Visitor v) { v.visit(this); } // Double Dispatch
}

public class PriceCalcVisitor implements Visitor {
    public void visit(Book b) { System.out.println("Book cost: " + b.getPrice()); }
    public void visit(Fruit f) { System.out.println("Fruit cost: " + f.getWeight() * pricePerKg); }
}
```

## ✅ Applicability

- Use the Visitor when you need to perform an operation on all elements of a complex object structure (for example, an object tree).
- Use the Visitor to clean up the business logic of auxiliary behaviors.
- Use the pattern when a behavior makes sense only in some classes of a class hierarchy, but not in others.

## ⚖️ Pros and Cons

| Pros                                                                                                                                    | Cons                                                                                                                           |
| :-------------------------------------------------------------------------------------------------------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------- |
| Open/Closed Principle. You can introduce a new behavior that can work with objects of different classes without changing these classes. | You need to update all visitors each time a class gets added to or removed from the element hierarchy.                         |
| Single Responsibility Principle.                                                                                                        | Visitors might lack the necessary access to the private fields and methods of the elements that they're supposed to work with. |
