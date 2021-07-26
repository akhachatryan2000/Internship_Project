package DesignPatterns.Bridge5;

public class LIne extends Shape {

    public LIne(DrawApi drawApi) {
        super(drawApi);
    }

    @Override
    public void draw() {
        drawApi.drawLine(4, 5, 6, 7);

    }
}
