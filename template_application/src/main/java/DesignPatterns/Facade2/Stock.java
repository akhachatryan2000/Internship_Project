package DesignPatterns.Facade2;

public class Stock extends Equity{
    public Stock(String symbol) {
        super(symbol);
    }

    @Override
    public void sell(int shares) {
        throw new IllegalCallerException("Can't sell ");

    }

    @Override
    public void buy(int shares) {
        System.out.println("Success");

    }


    @Override
    public int getPrice() {
        return 45;
    }
}
