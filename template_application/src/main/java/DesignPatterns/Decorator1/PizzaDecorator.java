package DesignPatterns.Decorator1;

import DesignPatterns.Decorator1.PizzaElement;

public abstract class PizzaDecorator extends PizzaElement {

    private PizzaElement pizzaElement;

    public PizzaDecorator(PizzaElement element) {
        this.pizzaElement = element;
    }

    public  int getPrice(){
        return pizzaElement.getPrice();

    }
}
