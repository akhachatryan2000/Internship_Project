package DesignPatterns.Decorator2;

public abstract class PizzaToping extends PizzaElement {

    private PizzaElement pizzaElement;

    public PizzaToping(PizzaElement pizzaElement) {
        this.pizzaElement = pizzaElement;
    }

    public int getPrice() {
        return pizzaElement.getPrice();
    }
}
