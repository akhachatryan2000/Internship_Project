package DesignPatterns.AbstractFactory;

public class Lion extends Carnivore {
    @Override
    public void eat(Herbivore herbivore) {
        System.out.println("Lion is eating Zebra");

    }
}
