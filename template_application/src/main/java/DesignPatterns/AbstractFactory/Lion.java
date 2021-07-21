package DesignPatterns.AbstractFactory;

public class Lion extends Carnivore{
    @Override
    public void eat(Herbivore herbivore) {
        System.out.println("The lion is eating the zebra");
    }
}
