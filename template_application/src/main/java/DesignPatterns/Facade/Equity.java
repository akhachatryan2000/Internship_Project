package DesignPatterns.Facade;

public abstract class Equity {
    private String symbol;

    public Equity(String s) {
        symbol = s;
    }

    public abstract void buy(int shares);

    public abstract void sell(int shares);

    public abstract int getPrice();
}
