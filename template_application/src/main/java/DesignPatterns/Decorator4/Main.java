package DesignPatterns.Decorator4;

public class Main {
    public static void main(String[] args) {
        PizzaElement pizzaElement = new Funghi();
        PizzaToping pizzaToping = new WithExtraCheese(pizzaElement);
        System.out.println(pizzaElement.getPrice());
        System.out.println(pizzaToping.getPrice());
    }
}
