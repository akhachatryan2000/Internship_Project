package DesignPatterns.Flyweight2;

import java.awt.*;

public class TreeType {

    private String name;

    private String texture;

    private Color color;

    public TreeType(String name, String texture, Color color) {
        this.name = name;
        this.texture = texture;
        this.color = color;
    }

    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 3, 5);
        g.setColor(color);
        g.fillOval(x - 5, y - 10, 10, 10);
    }
}
