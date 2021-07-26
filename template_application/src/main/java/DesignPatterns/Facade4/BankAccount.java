package DesignPatterns.Facade4;

public abstract class BankAccount {

    private int accountNUmber;

    public BankAccount(int accountNUmber) {
        this.accountNUmber = accountNUmber;
    }

    public abstract int getAccountBalance();

    public abstract void deposit(int amount);

    public abstract void withdraw(int amount);

}
