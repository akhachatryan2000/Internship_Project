package DesignPatterns.Facade;

public class Stock extends Equity{

    public Stock(String s) {
        super(s);
    }

    @Override
    public void buy(int shares) {
        System.out.println("Always succeeds");


    }

    @Override
    public void sell(int shares) {
        System.out.println("Selled");

    }

    @Override
    public int getPrice() {
        return 20;
    }
}
