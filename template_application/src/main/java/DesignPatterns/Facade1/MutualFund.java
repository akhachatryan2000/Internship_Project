package DesignPatterns.Facade1;


import javax.security.auth.callback.CallbackHandler;

public class MutualFund {
    private int accountNumber;

    public MutualFund(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void buy(String symbol,int shares) {
        CashAccount cashAccount= new CashAccount(accountNumber);
        EquityFactory equityFactory= EquityFactory.getEquity();
        Equity equity= equityFactory.createEquity(symbol);

        int amount= equity.getPrice();
        int balance=cashAccount.getAccountBalance();
        if (balance>=amount) {
            cashAccount.withdraw(amount);
            equity.buy(shares);
            System.out.println("Successfully bought");
            System.out.println("new balance is " + (balance-amount));
        }

    }

}
