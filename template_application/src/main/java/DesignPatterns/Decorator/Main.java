package DesignPatterns.Decorator;

public class Main {
    public static void main(String[] args) {
        Margarita margarita= new Margarita();
        System.out.println(margarita.getPrice());
        PizzaToping pizzaToping= new WithExtraCheese(margarita);
        pizzaToping.getPrice();

    }
}
