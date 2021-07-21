package DesignPatterns.FactoryMethod;

public class DuckCreator extends ToyCreator{
    @Override
    protected Toy createToy() {
        return new Duck();
    }
}
