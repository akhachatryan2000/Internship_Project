package DesignPatterns.Decorator1;

public  class Main {
    public static void main(String[] args) {
        PizzaDecorator pizzaDecorator= new WithExtraCheese(new Margarita());
        System.out.println(pizzaDecorator.getPrice());

    }
}
