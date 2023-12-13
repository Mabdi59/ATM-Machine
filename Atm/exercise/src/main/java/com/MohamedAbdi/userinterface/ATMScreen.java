package com.MohamedAbdi.userinterface;

import java.util.Scanner;

public class ATMScreen {

    private Scanner scanner;

    public ATMScreen() {
        scanner = new Scanner(System.in);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
    }

    public int getUserInput() {
        System.out.print("Please enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            System.out.print("Please enter your choice: ");
        }
        return scanner.nextInt();
    }

    public String getInputString() {
        return scanner.next();
    }


}