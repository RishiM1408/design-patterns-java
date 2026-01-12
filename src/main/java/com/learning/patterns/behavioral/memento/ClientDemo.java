package com.learning.patterns.behavioral.memento;

/**
 * Client Demo for Memento Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Memento Pattern Demo (Undo Feature) ---");

        Editor editor = new Editor();
        History history = new History();

        // 1. Type "a"
        editor.setContent("a");
        history.push(editor.createState());
        System.out.println("Current: " + editor.getContent());

        // 2. Type "b"
        editor.setContent("ab");
        history.push(editor.createState());
        System.out.println("Current: " + editor.getContent());

        // 3. Type "c"
        editor.setContent("abc");
        System.out.println("Current: " + editor.getContent());

        // Undo 1
        System.out.println("\n...Undo...");
        editor.restore(history.pop());
        System.out.println("Current: " + editor.getContent());

        // Undo 2
        System.out.println("\n...Undo...");
        editor.restore(history.pop());
        System.out.println("Current: " + editor.getContent());
    }
}
