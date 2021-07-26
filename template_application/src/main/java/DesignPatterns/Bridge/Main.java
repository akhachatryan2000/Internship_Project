package DesignPatterns.Bridge;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Line(new MultiDraw());
        shape.draw();

    }
}
