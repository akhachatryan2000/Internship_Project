package DesignPatterns.Facade1;

public class CashAccount extends BankAccount {

    private int balance = 1000;

    public CashAccount(int accountNumber) {
        super(accountNumber);
    }

    @Override
    public int getAccountBalance() {
        return balance;
    }

    @Override
    public void withdraw(int amount) {
        balance -= amount;

    }

    @Override
    public void deposit(int amount) {
        balance += amount;

    }
}
