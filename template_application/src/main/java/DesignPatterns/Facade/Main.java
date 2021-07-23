package DesignPatterns.Facade;

public class Main {
    public static void main(String[] args) {
        MutualFund mutualFund = new MutualFund(123456);
        mutualFund.buy("Apple", 10);

    }
}
