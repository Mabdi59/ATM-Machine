package com.MohamedAbdi.bank;

public class FundTransfer extends Transaction {

    private String targetAccountNumber;
    private double amount;

    public FundTransfer(String accountNumber, BankDatabase bankDatabase,
                        String targetAccountNumber, double amount) {
        super(accountNumber, bankDatabase);
        this.targetAccountNumber = targetAccountNumber;
        this.amount = amount;
    }

    @Override
    public void execute() {
        if (getBankDatabase().transferFunds(getAccountNumber(), targetAccountNumber, amount)) {
            System.out.println("Transferred $" + amount + " from account " + getAccountNumber() +
                    " to account " + targetAccountNumber);
        } else {
            System.out.println("Fund transfer failed.");
        }
    }
}