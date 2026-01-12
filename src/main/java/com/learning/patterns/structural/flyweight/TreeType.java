package com.learning.patterns.structural.flyweight;

/**
 * The Flyweight Interface (Optional, or just a concrete class).
 * Represents the Intrinsic State (shared data).
 */
public class TreeType {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing TreeType: " + name + " (" + color + ") at " + x + ", " + y);
    }
}
