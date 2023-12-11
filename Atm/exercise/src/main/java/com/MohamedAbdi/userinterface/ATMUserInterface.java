package com.MohamedAbdi.userinterface;


import com.MohamedAbdi.bank.BankDatabase;
import com.MohamedAbdi.AtmHardware.CardReader;
import com.MohamedAbdi.AtmHardware.CashDispenser;
import com.MohamedAbdi.AtmHardware.Printer;
import com.MohamedAbdi.Security.UserAuthentication;

import java.util.HashMap;
import java.util.Map;

public class ATMUserInterface {

    private ATMScreen screen;
    private BankDatabase bankDatabase;
    private CardReader cardReader;
    private CashDispenser cashDispenser;
    private Printer printer;
    private UserAuthentication userAuth;

    public ATMUserInterface(BankDatabase bankDatabase, CardReader cardReader, CashDispenser cashDispenser, Printer printer) {
        this.screen = new ATMScreen();
        this.bankDatabase = bankDatabase;
        this.cardReader = cardReader;
        this.cashDispenser = cashDispenser;
        this.printer = printer;
        this.userAuth = new UserAuthentication(bankDatabase);
    }

    public void run() {
        screen.displayMessage("Welcome to ATM");
        String cardNumber = cardReader.readCard(); // Simulate card reading
        screen.displayMessage("Please enter your PIN:");
        String pin = screen.getInputString(); // Get user input for PIN

        if (userAuth.authenticateUser(cardNumber, pin)) {
            String accountNumber = getAccountNumberFromCard(cardNumber); // Implement this method
            boolean running = true;
            while (running) {
                screen.displayMenu(new String[]{"1. Check Balance", "2. Withdraw", "3. Deposit", "4. Exit"});
                int choice = screen.getUserInput();
                switch (choice) {
                    case 1:
                        handleBalanceInquiry(accountNumber);
                        break;
                    case 2:
                        handleWithdrawal(accountNumber);
                        break;
                    case 3:
                        handleDeposit(accountNumber);
                        break;
                    case 4:
                        screen.displayMessage("Thank you for using ATM. Goodbye!");
                        running = false;
                        break;
                    default:
                        screen.displayMessage("Invalid choice. Please try again.");
                        break;
                }
            }
        } else {
            screen.displayMessage("Authentication failed. Please try again.");
        }
    }

    private String getAccountNumberFromCard(String cardNumber) {
        Map<String, String> cardToAccountMap = new HashMap<>();
        cardToAccountMap.put("123456789", "Account01");
        cardToAccountMap.put("987654321", "Account02");

        return cardToAccountMap.getOrDefault(cardNumber, null);
    }

    private void handleBalanceInquiry(String accountNumber) {
        double balance = bankDatabase.getAccountBalance(accountNumber);
        screen.displayMessage("Your current balance is: $" + balance);
    }
    private void handleWithdrawal(String accountNumber) {
        screen.displayMessage("Enter amount to withdraw:");
        int amount = screen.getUserInput();

        if (cashDispenser.dispenseCash(amount) && bankDatabase.withdrawFromAccount(accountNumber, amount)) {
            screen.displayMessage("Please take your cash.");
            printer.printReceipt("Withdrawal: $" + amount);
        } else {
            screen.displayMessage("Unable to dispense cash.");
        }
    }
    private void handleDeposit(String accountNumber) {
        screen.displayMessage("Enter amount to deposit:");
        int amount = screen.getUserInput();

        bankDatabase.depositToAccount(accountNumber, amount);
        screen.displayMessage("Your deposit has been processed.");
        printer.printReceipt("Deposit: $" + amount);
    }
}
