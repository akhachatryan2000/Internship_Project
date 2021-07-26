package DesignPatterns.Facade2;

public class EquityFactory {

    private static EquityFactory equity;


    private EquityFactory() {

    }

    public EquityFactory getEquity() {
        if (equity == null) {
            new EquityFactory();
        }
        return equity;
    }

    public Equity createEquity(String symbol) {
        return new Stock(symbol);

    }
}
