package com.MohamedAbdi.Security;

import com.MohamedAbdi.bank.Account;
import com.MohamedAbdi.bank.BankDatabase;

public class UserAuthentication {

    private BankDatabase bankDatabase;

    public UserAuthentication(BankDatabase bankDatabase) {
        this.bankDatabase = bankDatabase;
    }

    public boolean authenticateUser(String accountNumber, String pin) {
        Account account = bankDatabase.getAccount(accountNumber);
        if (account != null) {
            String encryptedStoredPin = account.getEncryptedPin();
            String encryptedInputPin = EncryptionUtil.encrypt(pin);


            System.out.println("Debug: Stored Encrypted PIN: " + encryptedStoredPin);
            System.out.println("Debug: Input Encrypted PIN: " + encryptedInputPin);

            return encryptedStoredPin != null && encryptedStoredPin.equals(encryptedInputPin);
        }
        return false;
    }
}