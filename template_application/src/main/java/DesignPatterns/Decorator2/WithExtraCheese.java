package DesignPatterns.Decorator2;

public class WithExtraCheese extends PizzaToping{
    public WithExtraCheese(PizzaElement pizzaElement) {
        super(pizzaElement);
    }

    @Override
    public int getPrice() {
        return super.getPrice() +10;
    }
}
