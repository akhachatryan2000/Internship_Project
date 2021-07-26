package DesignPatterns.Decorator2;

public class Main {
    public static void main(String[] args) {
        PizzaElement pizzaElement = new Margarita();
        PizzaToping pizzaToping = new WithExtraHam(pizzaElement);
        int price = pizzaToping.getPrice();
        System.out.println("The final price will be " + price);
    }
}
