package DesignPatterns.Decorator1;

public class WithExtraCheese extends PizzaDecorator{
    public WithExtraCheese(PizzaElement element) {
        super(element);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
