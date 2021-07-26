package DesignPatterns.Facade1;

public final class EquityFactory {

    private static EquityFactory instance;

    private EquityFactory() {

    }

    public static EquityFactory getEquity() {
        if (instance == null) {
            return new EquityFactory();
        }
        return instance;
    }

    public Equity createEquity(String symbol) {
        return new Stock(symbol);
    }
}
