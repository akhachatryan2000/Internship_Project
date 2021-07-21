package DesignPatterns.FactoryMethod;

import java.awt.*;

public class Superman extends Toy{
    @Override
    public int getPowderQuantity() {
        return 25;
    }

    @Override
    public int getHeatingTime() {
        return 56;
    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }
}
