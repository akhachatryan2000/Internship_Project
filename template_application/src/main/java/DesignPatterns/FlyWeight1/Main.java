package DesignPatterns.FlyWeight1;

import java.awt.*;

public class Main {

    static int canvas_size = 500;
    static int treesToDraw = 1000000;
    static int treeTypes = 2;

    public static void main(String[] args) {
        Forest forest = new Forest();
        for (int i = 0; i < Math.floor(treesToDraw / treeTypes); i++) {
            forest.plant(random(0, canvas_size), random(0, canvas_size), " Summer Oak", Color.GREEN, "Summer oak texture");
        }
        forest.setSize(canvas_size,canvas_size);
        forest.setVisible(true);

    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() + max);

    }
}
