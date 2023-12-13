package com.MohamedAbdi.bank;

public class Account {
    private String accountNumber;
    private double balance;
    private String encryptedPin;

    public Account(String accountNumber, double initialBalance, String encryptedPin) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.encryptedPin = encryptedPin;
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Getter for encrypted PIN
    public String getEncryptedPin() {
        return encryptedPin;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Method to withdraw money from the account
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
        System.out.println("Withdrawn: $" + amount);
        return true;
    }
}