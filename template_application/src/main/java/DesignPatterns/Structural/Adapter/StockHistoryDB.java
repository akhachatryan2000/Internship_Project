package DesignPatterns.Structural.Adapter;

public class StockHistoryDB {
    //returns the stock prices for 12 months

    public double[] getApple() {
        return new double[]{12.3, 56.2, 56.3, 78.1, 56.1, 45.9, 12.2, 45.1, 36.1, 14.2, 52.3, 52.9};
    }

    public double[] getMicrosoft() {
        return new double[]{45.2, 12.2, 52.3, 12.3, 89.3, 12.6, 12.4, 23.2, 32.2, 45.1, 74.2, 56.3};
    }

    public double[] getGoogle() {
        return new double[]{20.0, 12.2, 52.3, 12.3, 89.3, 12.6, 12.4, 23.2, 32.2, 45.1, 74.2, 56.3};
    }
}
