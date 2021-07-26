package DesignPatterns.Decorator2;

public class WithExtraHam extends PizzaToping {
    public WithExtraHam(PizzaElement pizzaElement) {
        super(pizzaElement);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 50;
    }
}
