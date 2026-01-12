# Memento Pattern

## 🔍 Definition

**Memento** is a behavioral design pattern that lets you save and restore the previous state of an object without revealing the details of its implementation.

## 🧩 The Problem

You are implementing "Undo" for a Text Editor.
To save state, you need to copy private fields (`cursorPosition`, `fontStyle`, `hiddenControlChars`).
If you expose these fields (make them public), you break Encapsulation. If you don't, you can't backup the object externally.

## 💡 The Solution

Delegate the creation of the state snapshot to the actual object owner.

1.  **Originator** (The Editor): Can create a snapshot of its own state.
2.  **Memento**: A simple object holding the snapshot. It's opaque to others but readable by the Originator.
3.  **Caretaker**: Holds the stack of Mementos (History). It just stores them, it doesn't peek inside.

## 🏗️ Real-World Analogy

**Video Game Save Point**: Before a boss fight, you save your game. The "Save File" (Memento) encapsulates your HP, Items, and Location. You (Caretaker) store this file. If you die, you load the file, restoring the Game (Originator) to that exact state.

## 💻 Code Snippet

```java
// Memento (Immutable)
public class EditorState {
    private final String content;
    public EditorState(String content) { this.content = content; }
    public String getContent() { return content; }
}

// Originator
public class Editor {
    private String content;
    public EditorState createState() { return new EditorState(content); }
    public void restore(EditorState state) { content = state.getContent(); }
}

// Caretaker
public class History {
    private Stack<EditorState> states = new Stack<>();
    public void push(EditorState state) { states.push(state); }
    public EditorState pop() { return states.pop(); }
}
```

## ✅ Applicability

- Use the Memento pattern when you want to produce snapshots of the object's state to be able to restore a previous state of the object.
- Use the pattern when direct access to the object's fields/getters/setters violates its encapsulation.

## ⚖️ Pros and Cons

| Pros                                                                                                          | Cons                                                                                                                                   |
| :------------------------------------------------------------------------------------------------------------ | :------------------------------------------------------------------------------------------------------------------------------------- |
| You can produce snapshots of the object's state without violating its encapsulation.                          | The app might consume lots of RAM if clients create mementos too often.                                                                |
| You can simplify the originator by letting the caretaker maintain the history of the originator's life cycle. | Dynamic programming languages, such as PHP, Python, and JavaScript, can't guarantee that the state within the memento stays untouched. |
