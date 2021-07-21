package DesignPatterns.AbstractFactory;


public class Ecosystem {
    private Carnivore carnivore;

    private Herbivore herbivore;

    public Ecosystem(ContinentFactory factory) {
        carnivore = factory.createCarnivore();
        herbivore = factory.createHerbivore();
    }

    public void run() {
        carnivore.eat(herbivore);
    }

}
