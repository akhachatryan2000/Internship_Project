package DesignPatterns.Bridge;

public class Line extends Shape{
    public Line(DrawAPi drawAPi) {
        super(drawAPi);
    }

    @Override
    public void draw() {
        drawAPi.drawLine(5,6);


    }
}
