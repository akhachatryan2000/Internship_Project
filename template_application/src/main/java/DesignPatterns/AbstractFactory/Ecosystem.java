package DesignPatterns.AbstractFactory;

public class Ecosystem {
    private Herbivore herbivore;
    private Carnivore carnivore;


    public Ecosystem(ContinentFactory factory) {
        herbivore = factory.createHerbivore();
        carnivore = factory.createCarnivore();
    }

    public void run() {
        carnivore.eat(herbivore);

    }
}
