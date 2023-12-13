package com.MohamedAbdi.userinterface;


import com.MohamedAbdi.AtmHardware.CardReader;
import com.MohamedAbdi.AtmHardware.CashDispenser;
import com.MohamedAbdi.AtmHardware.Printer;
import com.MohamedAbdi.bank.BankDatabase;
import com.MohamedAbdi.Security.UserAuthentication;
import com.MohamedAbdi.userinterface.ATMUserInterface;

public class Main {
    public static void main(String[] args) {
        // Create instances of the ATM components
        BankDatabase bankDatabase = new BankDatabase();
        CardReader cardReader = new CardReader();
        CashDispenser cashDispenser = new CashDispenser();
        Printer printer = new Printer();
        UserAuthentication userAuth = new UserAuthentication(bankDatabase);

        // Create and run the ATM user interface
        ATMUserInterface atmUI = new ATMUserInterface(bankDatabase, cardReader, cashDispenser, printer, userAuth);
        atmUI.run();
    }
}