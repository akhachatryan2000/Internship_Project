package DesignPatterns.Decorator4;

public class WithExtraCheese extends PizzaToping {
    public WithExtraCheese(PizzaElement pizzaElement) {
        super(pizzaElement);
    }

    @Override
    public int getPrice() {
        return pizzaElement.getPrice() + 100;
    }
}
