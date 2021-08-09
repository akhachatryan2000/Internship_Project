package DesignPatterns.AbstractFactory898;

public class Ecosystem {

    Carnivore carnivore;

    Herbivore herbivore;

    Ecosystem(ContinentFactory factory) {
        carnivore = factory.createCarnivore();
        herbivore = factory.herbivore();
    }

    public void run() {

    }
}
