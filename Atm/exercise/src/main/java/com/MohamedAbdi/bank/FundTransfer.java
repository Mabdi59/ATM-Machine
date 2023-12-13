package com.MohamedAbdi.bank;

public class FundTransfer extends Transaction {

    private String targetAccountNumber;
    private double amount;

    public FundTransfer(String accountNumber, BankDatabase bankDatabase, String targetAccountNumber, double amount) {
        super(accountNumber, bankDatabase);
        this.targetAccountNumber = targetAccountNumber;
        this.amount = amount;
    }

    public void execute() {

        getBankDatabase().transferFunds(getAccountNumber(), targetAccountNumber, amount);
    }
}