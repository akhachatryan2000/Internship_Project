package DesignPatterns.Facade1;

public class Stock extends Equity {  //subsystem


    public Stock(String symbol) {
        super(symbol);
    }

    @Override
    public void buy(int shares) {
        System.out.println("Always succeeds");

    }

    @Override
    public void sell(int shares) {
        throw new IllegalCallerException("cant sell the stock");

    }

    @Override
    public int getPrice() {
        return 10;
    }
}
