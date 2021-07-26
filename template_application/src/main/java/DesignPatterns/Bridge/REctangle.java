package DesignPatterns.Bridge;

public class REctangle extends Shape {

    public REctangle(DrawAPi drawAPi) {
        super(drawAPi);
    }

    @Override
    public void draw() {
        drawAPi.drawLine(4, 5);
        drawAPi.drawLine(4, 5);
        drawAPi.drawLine(4, 5);
        drawAPi.drawLine(4, 5);


    }
}
