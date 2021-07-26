package DesignPatterns.Bridge;

public class Square extends Shape{
    public Square(DrawAPi drawAPi) {
        super(drawAPi);
    }

    @Override
    public void draw() {
        drawAPi.drawLine(6,6);
        drawAPi.drawLine(6,6);
        drawAPi.drawLine(6,6);
        drawAPi.drawLine(6,6);



    }
}
