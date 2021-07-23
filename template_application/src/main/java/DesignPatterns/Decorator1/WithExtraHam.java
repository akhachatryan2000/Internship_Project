package DesignPatterns.Decorator1;

public class WithExtraHam extends PizzaDecorator {


    public WithExtraHam(PizzaElement element) {
        super(element);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 4;
    }
}
