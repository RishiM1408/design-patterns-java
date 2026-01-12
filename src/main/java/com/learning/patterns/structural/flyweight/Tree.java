package com.learning.patterns.structural.flyweight;

/**
 * Context (Extrinsic State).
 * Contains the unique data for each object (position).
 * References the Flyweight (TreeType).
 */
public class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}
