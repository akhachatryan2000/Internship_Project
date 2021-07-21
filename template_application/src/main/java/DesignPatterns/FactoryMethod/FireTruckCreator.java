package DesignPatterns.FactoryMethod;

public class FireTruckCreator extends ToyCreator {
    @Override
    protected Toy createToy() {
        return new FireTruck();
    }
}
