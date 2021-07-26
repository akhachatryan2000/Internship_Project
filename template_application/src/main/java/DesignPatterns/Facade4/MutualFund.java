package DesignPatterns.Facade4;

public class MutualFund {
    private int accountNumber;

    public MutualFund(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void buy(String symbol, int shares) {
        CashAccount cashAccount = new CashAccount(accountNumber);
        EquityFactory equityFactory = EquityFactory.getEquity();
        Equity equity = equityFactory.createEquity(symbol);
        int amount = equity.getPrice();
        int balance = cashAccount.getAccountBalance();
        if (balance >= amount) {
            cashAccount.withdraw(amount);
            equity.buy(shares);
            System.out.println("Successfully bought");
            System.out.println("Current balance is " + (balance - amount));
        }
    }

    //    private int accountNumber;
//
//    public MutualFund(int accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//
//    public void buy(String symbol,int shares) {
//        DesignPatterns.Facade1.CashAccount cashAccount= new CashAccount(accountNumber);
//        DesignPatterns.Facade1.EquityFactory equityFactory= EquityFactory.getEquity();
//        Equity equity= equityFactory.createEquity(symbol);
//
//        int amount= equity.getPrice();
//        int balance=cashAccount.getAccountBalance();
//        if (balance>=amount) {
//            cashAccount.withdraw(amount);
//            equity.buy(shares);
//            System.out.println("Successfully bought");
//            System.out.println("new balance is " + (balance-amount));
//        }
//
//    }
}
