package DesignPatterns.Facade;

public class MutualFund {

    private int accountNumber;

    public MutualFund(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void buy(String symbol, int shares) {
        CashAccount account = new CashAccount(accountNumber);
        EquityFactory factory = EquityFactory.getEquity();
        Equity equity = factory.createEquity(symbol);

        int amount = equity.getPrice() + shares;
        int balance = account.getAccountBalance();
        if (balance >= amount) {
            account.withdraw(amount);
            equity.buy(shares);
            System.out.println(shares + " " + symbol);
            System.out.println(account.getAccountBalance());
        } else {
            System.out.println("Insufficient balance" + account.getAccountBalance());
        }

    }
}
