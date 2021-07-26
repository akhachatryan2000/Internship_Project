package DesignPatterns.Bridge5;

public class Main {
    public static void main(String[] args) {
        Shape shape= new LIne(new OpenGlDraw());
        shape.draw();
        System.out.println(shape);
    }
}
