package DesignPatterns.Facade;

public final class EquityFactory {

    private static EquityFactory equity;

    private EquityFactory() {

    }

    public static EquityFactory getEquity() {
        if (equity != null) {
            return equity;
        }
        equity = new EquityFactory();
        return equity;
    }

    public Equity createEquity(String symbol) {
        return new Stock(symbol);
    }


}
