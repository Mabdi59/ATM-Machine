package com.MohamedAbdi;

import com.MohamedAbdi.bank.BankDatabase;
import com.MohamedAbdi.bank.BalanceInquiry;
import com.MohamedAbdi.bank.Deposit;
import com.MohamedAbdi.bank.Withdrawal;

import java.util.Scanner;

public class ATMMachineSoftware {

    private BankDatabase bankDatabase;
    private Scanner scanner;

    public ATMMachineSoftware() {
        bankDatabase = new BankDatabase();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ATMMachineSoftware atmMachine = new ATMMachineSoftware();
        atmMachine.run();
    }

    private void run() {
        System.out.print("Please enter your account number: ");
        String userAccountNumber = scanner.nextLine();

        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getUserInput();
            switch (choice) {
                case 1:
                    // Balance Inquiry
                    BalanceInquiry balanceInquiry = new BalanceInquiry(userAccountNumber, bankDatabase);
                    balanceInquiry.execute();
                    break;
                case 2:
                    // Withdraw Cash
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    Withdrawal withdrawal = new Withdrawal(userAccountNumber, bankDatabase, withdrawAmount);
                    withdrawal.execute();
                    break;
                case 3:
                    // Deposit Funds
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    Deposit deposit = new Deposit(userAccountNumber, bankDatabase, depositAmount);
                    deposit.execute();
                    break;
                case 4:
                    // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("Welcome to the ATM Machine");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Cash");
        System.out.println("3. Deposit Funds");
        System.out.println("4. Exit");
    }

    private int getUserInput() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            System.out.print("Enter your choice: ");
        }
        return scanner.nextInt();
    }
}