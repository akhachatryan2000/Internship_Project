package DesignPatterns.Decorator3;

public class WithExtraCheese extends PizzaTopping{

    public WithExtraCheese(PizzaElement pizzaElement) {
        super(pizzaElement);
    }

    @Override
    public int getPrice() {
        return super.getPrice()+10;
    }
}
