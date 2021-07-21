package DesignPatterns.AbstractFactory;

public class Ecosystem {
    private Herbivore herbivore;
    private Carnivore carnivore;

    public Ecosystem(ContinentFactory continentFactory) {
        herbivore= continentFactory.createHerbivore();
        carnivore= continentFactory.createCarnivore();
    }

    public void run() {
        carnivore.eat(herbivore);

    }
}
