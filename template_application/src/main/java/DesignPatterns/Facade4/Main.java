package DesignPatterns.Facade4;

public class Main {
    public static void main(String[] args) {
        MutualFund mutualFund = new MutualFund(1211545);
        mutualFund.buy("Apple", 45);
    }
}
