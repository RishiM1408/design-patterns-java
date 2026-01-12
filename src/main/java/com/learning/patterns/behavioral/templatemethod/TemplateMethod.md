# Template Method Pattern

## 🔍 Definition

**Template Method** is a behavioral design pattern that defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.

## 🧩 The Problem

You are analyzing documents.

- **PDF**: `openFile()`, `extractPdfText()`, `analyze()`, `generateReport()`, `close()`.
- **CSV**: `openFile()`, `extractCsvData()`, `analyze()`, `generateReport()`, `close()`.
  There is huge code duplication. The overall algorithm is the same; only the "extraction" step differs.

## 💡 The Solution

Create a base class `DataMiner`.
Define a `mine()` method that calls the steps: `open -> extract -> analyze -> close`.
Make `mine()` **final** (so it can't be changed).
Make `extract()` **abstract**.
Subclasses (`PdfMiner`, `CsvMiner`) implement only the `extract()` specific logic.

## 🏗️ Real-World Analogy

**Building a Standard House**:

1.  Pour Foundation (Standard).
2.  Build Walls (Standard).
3.  **Install Windows/Doors** (Customizable: Wood vs Glass).
4.  Build Roof (Standard).
    The Architect defines the template. The Builder customizes the specific steps (3) but must follow the sequence.

## 💻 Code Snippet

```java
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    // Template method
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

public class Cricket extends Game {
    void initialize() { System.out.println("Cricket Setup"); }
    void startPlay() { System.out.println("Cricket Playing"); }
    void endPlay() { System.out.println("Cricket Finished"); }
}
```

## ✅ Applicability

- Use the Template Method pattern when you want to let clients extend only particular steps of an algorithm, but not the whole algorithm or its structure.
- Use the pattern when you have several classes that contain almost identical algorithms with some minor differences.

## ⚖️ Pros and Cons

| Pros                                                                                                                                                    | Cons                                                                                                             |
| :------------------------------------------------------------------------------------------------------------------------------------------------------ | :--------------------------------------------------------------------------------------------------------------- |
| You can let clients override only certain parts of a large algorithm, making them less affected by changes that happen to other parts of the algorithm. | You might violate the Liskov Substitution Principle by suppressing a default step implementation via a subclass. |
| You can pull the duplicate code into a superclass.                                                                                                      | Template methods tend to be harder to maintain the more steps they have.                                         |
