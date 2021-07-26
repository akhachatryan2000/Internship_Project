package DesignPatterns.Flyweight;

import java.awt.*;

public class Main {
    static int canvasSize = 500;
    static int treesToDraw = 1000000;
    static int treeTYpes = 2;

    public static void main(String[] args) {
        Forest forest = new Forest();
        for (int i = 0; i < treesToDraw / treeTYpes; i++) {
            forest.plantTree(2, 5, "Summer Oak", Color.GREEN, "SummerOakTexture");
            forest.plantTree(5, 6, "Autumn Oak", Color.ORANGE, "Autumn Oak texture");
        }
        forest.setSize(canvasSize, canvasSize);
        forest.setVisible(true);
    }
}
