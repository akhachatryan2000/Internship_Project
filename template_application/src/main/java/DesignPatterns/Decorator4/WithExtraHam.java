package DesignPatterns.Decorator4;

public class WithExtraHam extends PizzaToping {
    public WithExtraHam(PizzaElement pizzaElement) {
        super(pizzaElement);
    }

    @Override
    public int getPrice() {
        return pizzaElement.getPrice() + 500;
    }
}
