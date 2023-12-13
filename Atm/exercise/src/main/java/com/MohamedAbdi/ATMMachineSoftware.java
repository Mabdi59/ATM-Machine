package com.MohamedAbdi;

import com.MohamedAbdi.Util.Configuration;
import com.MohamedAbdi.Util.Logger;
import com.MohamedAbdi.bank.BankDatabase;
import com.MohamedAbdi.userinterface.ATMScreen;
import com.MohamedAbdi.userinterface.ATMUserInterface;
import com.MohamedAbdi.AtmHardware.CardReader;
import com.MohamedAbdi.AtmHardware.CashDispenser;
import com.MohamedAbdi.AtmHardware.Printer;
import com.MohamedAbdi.Security.UserAuthentication;

public class ATMMachineSoftware {

    private ATMUserInterface atmUI;
    private Configuration config;
    private BankDatabase bankDatabase;
    private CardReader cardReader;
    private CashDispenser cashDispenser;
    private Printer printer;
    private UserAuthentication userAuth;

    public ATMMachineSoftware(String configFilePath) {
        config = new Configuration("relative/path/to/config.txt");

        bankDatabase = new BankDatabase();
        cardReader = new CardReader();
        cashDispenser = new CashDispenser();
        printer = new Printer();
        userAuth = new UserAuthentication(bankDatabase);

        atmUI = new ATMUserInterface(bankDatabase, cardReader, cashDispenser, printer, userAuth);
    }

    public void start() {
        Logger.log("ATM Machine started.");
        atmUI.run();
        Logger.log("ATM Machine shut down.");
    }

    public static void main(String[] args) {
        ATMMachineSoftware atmMachine = new ATMMachineSoftware("relative/path/to/config.txt");
        atmMachine.start();
    }
}