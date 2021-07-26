package DesignPatterns.Facade2;

public abstract class BankAccount {

    private int accountNumber;

    public BankAccount(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public abstract void withdraw(int amount);

    public abstract void deposit(int amount);

    public abstract int getBalance();


}
