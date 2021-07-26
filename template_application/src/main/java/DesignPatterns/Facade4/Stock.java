package DesignPatterns.Facade4;

public class Stock extends Equity {
    private String symbol;


    public Stock(String symbol) {
        super(symbol);
    }

    @Override
    public void sell(int shares) {
        System.out.println("Can't sell this share");

    }

    @Override
    public void buy(int shares) {
        System.out.println("Always succeeds");
    }

    @Override
    public int getPrice() {
        return 100;
    }
}
