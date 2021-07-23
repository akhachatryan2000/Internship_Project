package DesignPatterns.FlyWeight;

import java.awt.*;

public class Main {

    static int canvasSize = 500;
    static int treestoDraw = 1000000;
    static int treeTypes = 2;

    public static void main(String[] args) {
        Forest forest = new Forest();
        for (int i = 0; i < Math.floor(treestoDraw / treeTypes); i++) {
            forest.plantTree(random(0, canvasSize), random(0, canvasSize), "Autumn Oak", Color.ORANGE, "Autumn oak texture stub");
            forest.plantTree(random(0, canvasSize), random(0, canvasSize), "Summer Oak", Color.GREEN, "Oak texture stub");
        }
        TreeType treetype = TreeFactory.getTreeType("Autumn Oak", Color.ORANGE, "AUtumn texture");
        System.out.println(treetype);
        System.out.println();
        forest.setSize(canvasSize, canvasSize);
        forest.setVisible(true);
        System.out.println(treestoDraw + " trees drawn");
        System.out.println("--------------------");
        System.out.println("Memory usage:");
        System.out.println("Tree size (8 bytes) * " + treestoDraw);
        System.out.println("Tree types size * " + treeTypes);
        System.out.println("********************");
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * (max - min) + 1);
    }
}
