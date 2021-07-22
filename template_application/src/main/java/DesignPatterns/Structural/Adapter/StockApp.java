package DesignPatterns.Structural.Adapter;

import java.util.ArrayList;
import java.util.List;

public class StockApp {

    public void showStockHistory(String company) {
        StockHistoryTarget adapter = new StockHistoryAdapter();
        ArrayList<Double> history = adapter.getStockPrices(company);
        for (double stockPrice : history) {
            System.out.print(stockPrice + " ");

        }
    }
}
