package DesignPatterns.Facade4;

public abstract class Equity {
    private String symbol;

    public Equity(String symbol) {
        this.symbol = symbol;
    }

    public abstract void sell(int shares);

    public abstract void buy(int shares);

    public abstract int getPrice();
}
