package DesignPatterns.AbstractFactory898;

public class AfricaFactory implements ContinentFactory{
    @Override
    public Carnivore createCarnivore() {
        return new Lion();
    }

    @Override
    public Herbivore herbivore() {
        return new ZEbra();
    }
}
