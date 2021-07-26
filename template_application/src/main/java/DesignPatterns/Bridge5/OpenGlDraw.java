package DesignPatterns.Bridge5;

public class OpenGlDraw extends DrawApi {
    @Override
    public void drawLine(int x, int y, int x1, int y2) {
        System.out.println("Multiple lines are drawed");
    }
}
