package com.MohamedAbdi.Security;

import com.MohamedAbdi.bank.Account;
import com.MohamedAbdi.bank.BankDatabase;

public class UserAuthentication {

    private BankDatabase bankDatabase;

    public UserAuthentication(BankDatabase bankDatabase) {
        this.bankDatabase = bankDatabase;
    }

    public boolean authenticateUser(String accountNumber, String pin) {
        // Retrieve the account associated with the account number
        Account account = bankDatabase.getAccount(accountNumber);
        if (account != null) {
            // Compare the provided PIN with the account's stored PIN
            String encryptedStoredPin = account.getEncryptedPin();
            String encryptedInputPin = EncryptionUtil.encrypt(pin);
            return encryptedStoredPin.equals(encryptedInputPin);
        }
        return false;
    }
}