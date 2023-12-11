package com.MohamedAbdi.bank;

public abstract class Transaction {

    private String accountNumber;
    private BankDatabase bankDatabase;

    public Transaction(String accountNumber, BankDatabase bankDatabase) {
        this.accountNumber = accountNumber;
        this.bankDatabase = bankDatabase;
    }

    protected String getAccountNumber() {
        return accountNumber;
    }

    protected BankDatabase getBankDatabase() {
        return bankDatabase;
    }

    public abstract void execute();
}