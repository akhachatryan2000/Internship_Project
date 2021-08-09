package DesignPatterns.AbstractFactory898;

public  class AustraliaFcatory implements ContinentFactory{
    @Override
    public Carnivore createCarnivore() {
        return new Dingo();
    }

    @Override
    public Herbivore herbivore() {
        return new Kangaroo();
    }
}
