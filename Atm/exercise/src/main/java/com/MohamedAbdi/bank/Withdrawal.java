package com.MohamedAbdi.bank;

public class Withdrawal extends Transaction {

    private double amount;

    public Withdrawal(String accountNumber, BankDatabase bankDatabase, double amount) {
        super(accountNumber, bankDatabase);
        this.amount = amount;
    }

    public void execute() {

        getBankDatabase().withdrawFromAccount(getAccountNumber(), amount);
    }
}
