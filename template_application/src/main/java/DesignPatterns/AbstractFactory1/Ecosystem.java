package DesignPatterns.AbstractFactory1;

public class Ecosystem {

    Carnivore carnivore;
    Herbivore herbivore;

    public Ecosystem(ContinentFactory factory) {
        carnivore = factory.createCarnivore();
        herbivore = factory.createHerbivore();
    }

    public void run() {
        carnivore.eat(herbivore);
    };
}
