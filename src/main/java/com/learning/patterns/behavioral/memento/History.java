package com.learning.patterns.behavioral.memento;

import java.util.Stack;

/**
 * The Caretaker.
 * Keeps track of the history of the Editor's state.
 */
public class History {
    // Stack is perfect for Last-In-First-Out Undo operations
    private Stack<EditorState> states = new Stack<>();

    public void push(EditorState state) {
        states.push(state);
    }

    public EditorState pop() {
        if (states.isEmpty())
            return null;
        return states.pop();
    }
}
