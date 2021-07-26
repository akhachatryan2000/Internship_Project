package DesignPatterns.Bridge;

public class SingleDraw extends DrawAPi{

    @Override
    public void drawLine(int x, int y) {

        System.out.println("Single line drawed" + x + " " + y);
    }
}
