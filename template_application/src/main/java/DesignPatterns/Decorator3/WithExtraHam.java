package DesignPatterns.Decorator3;

public class WithExtraHam extends PizzaTopping {
    public WithExtraHam(PizzaElement pizzaElement) {
        super(pizzaElement);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 20;
    }
}
