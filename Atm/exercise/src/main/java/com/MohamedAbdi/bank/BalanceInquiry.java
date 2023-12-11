package com.MohamedAbdi.bank;

public class BalanceInquiry extends Transaction {

    public BalanceInquiry(String accountNumber, BankDatabase bankDatabase) {
        super(accountNumber, bankDatabase);
    }
    @Override
    public void execute() {
        double balance = getBankDatabase().getAccountBalance(getAccountNumber());
        System.out.println("The balance for account " + getAccountNumber() + " is: $" + balance);
    }
}