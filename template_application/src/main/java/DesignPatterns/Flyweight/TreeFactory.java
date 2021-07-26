package DesignPatterns.Flyweight;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String texture) {
        if (treeTypes.get(name) == null) {
            TreeType treeType = new TreeType(name, color, texture);
            treeTypes.put(name, treeType);
        }
        return treeTypes.get(name);
    }

}
