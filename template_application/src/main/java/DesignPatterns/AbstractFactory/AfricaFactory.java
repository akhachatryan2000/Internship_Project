package DesignPatterns.AbstractFactory;

public class AfricaFactory implements ContinentFactory{


    @Override
    public Carnivore createCarnivore() {
        return new Lion();
    }

    @Override
    public Herbivore createHerbivore() {
        return new Zebra();
    }
}
