package com.learning.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Factory.
 * Manages the pool of Flyweights.
 */
public class TreeFactory {
    static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        // Since color/texture are tied to name in this simple example
        TreeType result = treeTypes.get(name);
        if (result == null) {
            result = new TreeType(name, color, texture);
            treeTypes.put(name, result);
            System.out.println("TreeFactory: Created new TreeType -> " + name);
        }
        return result;
    }
}
