package com.MohamedAbdi.bank;

public class Account {
    private String accountNumber;
    private double balance;
    private String encryptedPin;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.encryptedPin = encryptedPin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getEncryptedPin() {
        return encryptedPin;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            // Handle invalid deposit amount (e.g., negative value)
            System.out.println("Invalid deposit amount");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
            return false;
        }
        if (balance < amount) {
            System.out.println("Insufficient funds.");
            return false;
        }
        balance -= amount;
        return true;
    }
}