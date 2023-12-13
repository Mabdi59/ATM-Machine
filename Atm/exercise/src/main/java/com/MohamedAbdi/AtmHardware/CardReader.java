package com.MohamedAbdi.AtmHardware;
import java.util.Scanner;

public class CardReader {

    private Scanner scanner;

    public CardReader() {
        this.scanner = new Scanner(System.in);
    }

    public String readCard() {
        System.out.println("Please enter your card number:");
        return scanner.nextLine();
    }

    public boolean validateCard(String cardNumber) {
        return cardNumber != null && cardNumber.length() == 16;
    }
}