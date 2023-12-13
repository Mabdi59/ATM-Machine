package com.MohamedAbdi.Security;

import com.MohamedAbdi.bank.BankDatabase;

public class Main {
    public static void main(String[] args) {
        BankDatabase bankDatabase = new BankDatabase();
        UserAuthentication userAuth = new UserAuthentication(bankDatabase);

        String accountNumber = "123456789"; // Example account number
        String pin = "1234"; // Example PIN

        boolean isAuthenticated = userAuth.authenticateUser(accountNumber, pin);

        if (isAuthenticated) {
            System.out.println("User authenticated successfully.");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}
