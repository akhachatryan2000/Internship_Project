package DesignPatterns.FactoryMethod;

public class SupermanCreator extends ToyCreator{
    @Override
    protected Toy createToy() {
        return new Superman();
    }
}
