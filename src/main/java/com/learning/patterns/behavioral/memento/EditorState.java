package com.learning.patterns.behavioral.memento;

/**
 * The Memento.
 * Stores the internal state of the Editor.
 * Immutable class.
 */
public class EditorState {
    private final String content;

    public EditorState(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
