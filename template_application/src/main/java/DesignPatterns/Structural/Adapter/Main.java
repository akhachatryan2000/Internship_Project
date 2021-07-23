package DesignPatterns.Structural.Adapter;

public class Main {
    public static void main(String[] args) {
        StockApp stockApp = new StockApp();
        stockApp.showStockHistory("Apple");
        System.out.println();
        EnglishMan englishMan = new EnglishMan();
        englishMan.readTranslatedData();
    }
}
