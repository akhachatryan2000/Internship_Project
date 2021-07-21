package DesignPatterns.AbstractFactory;

public class AustraliaFactory extends ContinentFactory{
    @Override
    public Carnivore createCarnivore() {
        return new Dingo();
    }

    @Override
    public Herbivore createHerbivore() {
        return new Kangaroo();
    }
}
