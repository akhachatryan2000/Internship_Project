package DesignPatterns.Bridge5;


public class Square extends Shape {
    public Square(DrawApi drawApi) {
        super(drawApi);
    }

    @Override
    public void draw() {
        drawApi.drawLine(4,5,2,6);
        drawApi.drawLine(4,5,2,6);
        drawApi.drawLine(4,5,2,6);
        drawApi.drawLine(4,5,2,6);


    }
}
