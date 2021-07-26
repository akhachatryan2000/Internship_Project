package DesignPatterns.Facade2;

public class MutualFund {

    private int bankAccount;


    public void buy(String symbol, int shares) {
        CashAccount cashAccount = new CashAccount(bankAccount);
        int balance = cashAccount.getBalance();
        Equity equity = new Stock(symbol);
        int price = equity.getPrice();
        if (price <= balance) {
            cashAccount.withdraw(price);
            equity.buy(shares);
            System.out.println("Bought successfully");
            System.out.println("balance is " + (balance-price));
        }

    }
}