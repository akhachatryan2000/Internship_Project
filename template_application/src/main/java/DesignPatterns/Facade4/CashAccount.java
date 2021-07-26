package DesignPatterns.Facade4;

public class CashAccount extends BankAccount {
    private int balance = 1000;

    public CashAccount(int accountNUmber) {
        super(accountNUmber);
    }

    @Override
    public int getAccountBalance() {
        return balance;
    }

    @Override
    public void deposit(int amount) {
        balance += amount;

    }

    @Override
    public void withdraw(int amount) {
        balance -= amount;

    }
}
