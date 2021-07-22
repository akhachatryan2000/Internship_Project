package DesignPatterns.Structural.Adapter;

import java.util.ArrayList;
import java.util.List;

public class StockHistoryAdapter extends StockHistoryTarget {
    private StockHistoryDB stockHistoryDB = new StockHistoryDB();

    @Override
    public ArrayList<Double> getStockPrices(String company) {
        ArrayList<Double> historyList = new ArrayList<>();
        double[] history = new double[12];
        switch (company) {
            case ("Apple"):
                history = stockHistoryDB.getApple();
                break;
            case ("Microsoft"):
                history = stockHistoryDB.getMicrosoft();
                break;
            case ("Google"):
                history = stockHistoryDB.getGoogle();
                break;
        }
        for (double price : history) {
            historyList.add(price);
        }
        return historyList;

    }
}

