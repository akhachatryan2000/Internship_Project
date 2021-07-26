package DesignPatterns.Facade4;

import java.util.ArrayList;
import java.util.List;

public final class EquityFactory {
    private static EquityFactory equity;


    private EquityFactory() {

    }

    public static EquityFactory getEquity() {
        if (equity == null) {
            equity = new EquityFactory();
        }
        return equity;
    }

    public Stock createEquity(String symbol) {
        return new Stock(symbol);
    }


}
