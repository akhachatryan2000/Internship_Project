package DesignPatterns.FactoryMethod;

import java.awt.*;

public abstract class ToyCreator {
    protected abstract Toy createToy(); // this is the factory method

    public void makeToy() {
        Toy toy = createToy();
        int grams = toy.getPowderQuantity();
        preparePowder(grams);
        selectMold(toy);
        injectPowder(grams);
        int heatingTime = toy.getHeatingTime();
        heatMold(heatingTime);
        extractToy();
        Color color = toy.getColor();
        paintToy(color);


    }

    private void preparePowder(int grams) {
        System.out.println("Powder is " + grams);
    }

    private void selectMold(Toy toy) {
        System.out.println("Toy is" + toy);

    }

    private void injectPowder(int grams) {
        System.out.println("Injected powder is " + grams);
    }

    public void heatMold(int time) {
        System.out.println("Heating time is " + time);
    }

    private void extractToy() {
        System.out.println("Extracting toy");
    }

    private void paintToy(Color color) {
        System.out.println("Color is " + color);
    }

}
