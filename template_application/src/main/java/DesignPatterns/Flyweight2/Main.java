package DesignPatterns.Flyweight2;

import java.awt.*;

public class Main {
    static int canvasSize = 500;
    static int treesToDraw = 10000000;
    static int treeTypes = 2;

    public static void main(String[] args) {
        Forest forest = new Forest();
        for (int i = 0; i < 10000; i++) {
            forest.plantTree(5, 6, "Summer Oak", "SummerOak texture", Color.GREEN);
            forest.plantTree(8, 9, "Autumn Oak", "AutumnOak texture", Color.ORANGE);
        }
        forest.setVisible(true);
        forest.setSize(canvasSize, canvasSize);
    }
}
