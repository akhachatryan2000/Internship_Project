package DesignPatterns.AbstractFactory;

public class AustraliaFactory implements ContinentFactory{
    @Override
    public Carnivore createCarnivore() {
        return new Dingo();
    }

    @Override
    public Herbivore createHerbivore() {
        return new Kangaroo();
    }
}
