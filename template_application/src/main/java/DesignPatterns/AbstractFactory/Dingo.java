package DesignPatterns.AbstractFactory;

public class Dingo extends Carnivore {
    @Override
    public void eat(Herbivore herbivore) {
        System.out.println("The dingo is eating the kangaroo");
    }
}
