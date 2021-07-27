package DesignPatterns.Bridge5;

public class Main {
    public static void main(String[] args) {
        DrawApi drawApi= new OpenGlDraw();
        Shape shape= new LIne(drawApi);
        shape.draw();
        System.out.println(shape);
    }
}
