package DesignPatterns.Decorator;

public abstract class PizzaToping extends PizzaElement {

    protected PizzaElement component;

    protected PizzaToping(PizzaElement component) {
        component = component;
    }

    @Override
    public int getPrice() {
        return component.getPrice();
    }
}
