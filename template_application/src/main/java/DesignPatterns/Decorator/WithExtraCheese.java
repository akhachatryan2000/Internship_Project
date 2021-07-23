package DesignPatterns.Decorator;

public class WithExtraCheese extends PizzaToping{
    public WithExtraCheese(PizzaElement component) {
        super(component);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
