package com.MohamedAbdi;

import com.MohamedAbdi.Util.Configuration;
import com.MohamedAbdi.Util.Logger;
import com.MohamedAbdi.bank.BankDatabase;
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
        // Load the configuration settings
        config = new Configuration(configFilePath);

        // Initialize the components of the ATM
        bankDatabase = new BankDatabase(); // This should be set up with necessary accounts
        cardReader = new CardReader();
        cashDispenser = new CashDispenser(); // Ensure this is initialized with a sufficient amount of cash
        printer = new Printer();
        userAuth = new UserAuthentication(bankDatabase); // Ensure proper encryption of PINs in the bank database

        // Set up the ATM user interface
        atmUI = new ATMUserInterface(bankDatabase, cardReader, cashDispenser, printer, userAuth);
    }

    public void start() {
        // Log the start of the ATM machine
        Logger.log("ATM Machine started.");

        // Run the ATM user interface
        atmUI.run();

        // Log the shutdown of the ATM machine
        Logger.log("ATM Machine shut down.");
    }

    public static void main(String[] args) {
        // Create an instance of ATMMachineSoftware with the path to the configuration file
        ATMMachineSoftware atmMachine = new ATMMachineSoftware("path/to/config.txt");
        atmMachine.start(); // Start the ATM machine
    }
}