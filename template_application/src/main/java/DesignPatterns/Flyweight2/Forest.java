package DesignPatterns.Flyweight2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Forest extends JFrame {

    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String texture, Color color) {
        TreeType treeType = TreeFactory.getTreeType(name, color, texture);
        Tree tree = new Tree(x, y, treeType);
        trees.add(tree);
    }

    public void paintAllTrees(Graphics graphics) {
        for (Tree tree : trees) {
            tree.draw(graphics);

        }
    }
}
