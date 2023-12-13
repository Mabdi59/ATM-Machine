package com.MohamedAbdi.bank;

public class Deposit extends Transaction {

    private double amount;

    public Deposit(String accountNumber, BankDatabase bankDatabase, double amount) {
        super(accountNumber, bankDatabase);
        this.amount = amount;
    }

    @Override
    public void execute() {
        getBankDatabase().depositToAccount(getAccountNumber(), amount);
        System.out.println("Deposited $" + amount + " to account " + getAccountNumber());
    }
}