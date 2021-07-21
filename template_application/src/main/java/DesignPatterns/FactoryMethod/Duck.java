package DesignPatterns.FactoryMethod;

import java.awt.*;

public class Duck extends Toy{
    @Override
    public int getPowderQuantity() {
        return 10;
    }

    @Override
    public int getHeatingTime() {
        return 20;
    }

    @Override
    public Color getColor() {
        return Color.yellow;
    }
}
