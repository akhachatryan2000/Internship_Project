package DesignPatterns.Decorator3;

public class Main {
    public static void main(String[] args) {
        PizzaElement pizzaElement = new Funghi();
        PizzaTopping pizzaTopping = new WithExtraHam(pizzaElement);
        int price = pizzaTopping.getPrice();
        System.out.println("The final price of the pizza is " + price);
    }
}
