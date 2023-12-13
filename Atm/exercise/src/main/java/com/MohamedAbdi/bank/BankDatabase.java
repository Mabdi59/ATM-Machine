package com.MohamedAbdi.bank;

import com.MohamedAbdi.Security.EncryptionUtil;

import java.util.HashMap;
import java.util.Map;

public class BankDatabase {

    private Map<String, Account> accounts = new HashMap<>();

    public BankDatabase() {
        accounts = new HashMap<>();
        accounts.put("123456789", new Account("123456789", 1000.00, EncryptionUtil.encrypt("1738")));
        accounts.put("987654321", new Account("987654321", 500.00, EncryptionUtil.encrypt("1974")));
    }

        // Method to get an account by account number
        public Account getAccount(String accountNumber) {
            return accounts.get(accountNumber);
        }


    public double getAccountBalance(String accountNumber) {
        Account account = accounts.get(accountNumber);
        return (account != null) ? account.getBalance() : 1000;
    }

    public boolean withdrawFromAccount(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null && amount > 0) {
            return account.withdraw(amount);
        }
        return false;
    }

    public boolean transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = accounts.get(fromAccountNumber);
        Account toAccount = accounts.get(toAccountNumber);

        if (fromAccount != null && toAccount != null && fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            return true;
        }
        return false;
    }
    public void depositToAccount(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null && amount > 0) {
            account.deposit(amount);
        } else {
            if (account == null) {
                System.out.println("Account not found.");
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }
    }

}