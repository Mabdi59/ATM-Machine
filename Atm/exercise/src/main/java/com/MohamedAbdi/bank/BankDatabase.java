package com.MohamedAbdi.bank;

import com.MohamedAbdi.Security.EncryptionUtil;

import java.util.HashMap;
import java.util.Map;

public class BankDatabase {

    private Map<String, Account> accounts;

    public BankDatabase() {
        accounts = new HashMap<>();
        // Example accounts initialization with encrypted PINs
        accounts.put("123456789", new Account("123456789", 1000.00, EncryptionUtil.encrypt("1738")));
        accounts.put("987654321", new Account("987654321", 1000.00, EncryptionUtil.encrypt("1974")));
    }

    // Retrieve an account by account number
    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    // Get the balance of a specific account
    public double getAccountBalance(String accountNumber) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            return account.getBalance();
        } else {
            System.out.println("Account not found: " + accountNumber);
            return 0;
        }
    }

    // Deposit an amount to a specific account
    public void depositToAccount(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null && amount > 0) {
            account.deposit(amount);
        } else {
            System.out.println("Invalid deposit attempt.");
        }
    }

    // Withdraw an amount from a specific account
    public boolean withdrawFromAccount(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null && amount > 0) {
            return account.withdraw(amount);
        }
        return false;
    }

    // Transfer funds between two accounts
    public boolean transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = getAccount(fromAccountNumber);
        Account toAccount = getAccount(toAccountNumber);

        if (fromAccount != null && toAccount != null && fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            return true;
        }
        return false;
    }
}