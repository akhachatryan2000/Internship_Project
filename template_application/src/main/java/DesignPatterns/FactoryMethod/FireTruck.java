package DesignPatterns.FactoryMethod;

import java.awt.*;

public class FireTruck extends Toy{
    @Override
    public int getPowderQuantity() {
        return 40;
    }

    @Override
    public int getHeatingTime() {
        return 2;
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }
}
