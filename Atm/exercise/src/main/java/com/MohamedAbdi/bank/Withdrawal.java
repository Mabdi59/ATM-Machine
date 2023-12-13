package com.MohamedAbdi.bank;

public class Withdrawal extends Transaction {

    private double amount;

    public Withdrawal(String accountNumber, BankDatabase bankDatabase, double amount) {
        super(accountNumber, bankDatabase);
        this.amount = amount;
    }

    @Override
    public void execute() {
        if (getBankDatabase().withdrawFromAccount(getAccountNumber(), amount)) {
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid transaction.");
        }
    }
}