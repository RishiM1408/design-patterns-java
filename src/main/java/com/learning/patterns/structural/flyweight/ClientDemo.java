package com.learning.patterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * Client Demo for Flyweight Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Flyweight Pattern Demo ---");

        List<Tree> forest = new ArrayList<>();

        // Planting 10 trees
        for (int i = 0; i < 5; i++) {
            TreeType type = TreeFactory.getTreeType("Oak", "Green", "OakTextureStub");
            forest.add(new Tree(i * 10, 0, type));
        }

        for (int i = 0; i < 5; i++) {
            TreeType type = TreeFactory.getTreeType("Pine", "DarkGreen", "PineTextureStub");
            forest.add(new Tree(i * 10, 50, type));
        }

        // Draw forest
        for (Tree tree : forest) {
            tree.draw();
        }

        // Simulating the benefit
        System.out.println("\nTotal Trees: " + forest.size());
        System.out.println("TreeTypes created: " + TreeFactory.treeTypes.size());
        System.out.println("Memory Saving: We reused just " + TreeFactory.treeTypes.size() +
                " objects for intrinsic state instead of creating " + forest.size() + " full objects.");
    }
}
