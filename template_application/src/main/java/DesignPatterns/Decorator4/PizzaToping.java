package DesignPatterns.Decorator4;

public abstract class PizzaToping {
    PizzaElement pizzaElement;

    public PizzaToping(PizzaElement pizzaElement) {
        this.pizzaElement = pizzaElement;
    }
    public abstract int getPrice();
}
