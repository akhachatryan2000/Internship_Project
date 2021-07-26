package DesignPatterns.Decorator3;

public abstract class PizzaTopping extends PizzaElement {

    private PizzaElement pizzaElement;

    public PizzaTopping(PizzaElement pizzaElement) {
        this.pizzaElement = pizzaElement;
    }

    @Override
    public int getPrice() {
        return pizzaElement.getPrice();
    }
}
