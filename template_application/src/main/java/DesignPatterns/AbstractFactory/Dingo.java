package DesignPatterns.AbstractFactory;

public class Dingo extends Carnivore {
    @Override
    public void eat(Herbivore herbivore) {
        System.out.println("Dingo is eating Kangaroo");
    }
}
