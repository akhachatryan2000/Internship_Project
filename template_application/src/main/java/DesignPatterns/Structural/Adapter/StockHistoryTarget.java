package DesignPatterns.Structural.Adapter;

import java.util.ArrayList;
import java.util.List;

public abstract class StockHistoryTarget {
    public abstract ArrayList<Double> getStockPrices(String company);

}
