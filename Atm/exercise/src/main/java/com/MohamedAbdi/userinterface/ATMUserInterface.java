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

    public ATMUserInterface(BankDatabase bankDatabase, CardReader cardReader,
                            CashDispenser cashDispenser, Printer printer,
                            UserAuthentication userAuth) {
        this.screen = new ATMScreen();
        this.bankDatabase = bankDatabase;
        this.cardReader = cardReader;
        this.cashDispenser = cashDispenser;
        this.printer = printer;
        this.userAuth = userAuth;
    }

    public void run() {
        while (true) {
            screen.displayMessage("Welcome to ATM");
            String cardNumber = cardReader.readCard();
            screen.displayMessage("Please enter your PIN:");
            String pin = screen.getInputString();

            if (userAuth.authenticateUser(cardNumber, pin)) {
                String accountNumber = getAccountNumberFromCard(cardNumber);
                performUserTransactions(accountNumber);
            } else {
                screen.displayMessage("Authentication failed. Please try again.");
            }

            if (!userWantsToContinue()) {
                break;
            }
        }
        screen.displayMessage("Thank you for using ATM. Goodbye!");
    }

    private void performUserTransactions(String accountNumber) {
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
                    running = false;
                    break;
                default:
                    screen.displayMessage("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    private void handleDeposit(String accountNumber) {
        screen.displayMessage("Enter amount to deposit:");
        int amount = screen.getUserInput();

        if (amount <= 0) {
            screen.displayMessage("Invalid amount. Please enter a positive number.");
            return;
        }

        bankDatabase.depositToAccount(accountNumber, amount);
        screen.displayMessage("Your deposit of $" + amount + " has been processed.");

        // Debug statement before printing receipt
        System.out.println("Attempting to print deposit receipt...");
        printer.printReceipt("Deposit: $" + amount);
    }


    private void handleBalanceInquiry(String accountNumber) {
        double balance = bankDatabase.getAccountBalance(accountNumber);
        screen.displayMessage("Your current balance is: $" + balance);
    }

    private boolean userWantsToContinue() {
        screen.displayMessage("Do you want to perform another transaction? (yes/no):");
        String userInput = screen.getInputString().trim().toLowerCase();
        return "yes".equals(userInput);
    }
    private void handleWithdrawal(String accountNumber) {
        screen.displayMessage("Enter amount to withdraw:");
        int amount = screen.getUserInput(); // Ensure this method returns an integer

        if (amount <= 0) {
            screen.displayMessage("Invalid amount. Please enter a positive number.");
            return;
        }

        if (bankDatabase.withdrawFromAccount(accountNumber, amount)) {
            cashDispenser.dispenseCash(amount);
            screen.displayMessage("Please take your cash.");

            // Debug statement before printing receipt
            System.out.println("Attempting to print withdrawal receipt...");
            printer.printReceipt("Withdrawal: $" + amount);
        } else {
            screen.displayMessage("Insufficient funds or invalid transaction.");
        }
    }

    private String getAccountNumberFromCard(String cardNumber) {
        Map<String, String> cardToAccountMap = new HashMap<>();
        cardToAccountMap.put("123456789", "123456789"); // Map card number to the same account number
        cardToAccountMap.put("987654321", "987654321"); // Similarly for the second account

        return cardToAccountMap.getOrDefault(cardNumber, null);
    }
}