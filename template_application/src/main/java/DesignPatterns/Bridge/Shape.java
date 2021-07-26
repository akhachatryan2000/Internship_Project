package DesignPatterns.Bridge;

public abstract class Shape {

    public DrawAPi drawAPi;

    public Shape(DrawAPi drawAPi) {
        this.drawAPi = drawAPi;
    }

    public abstract void draw();
}
