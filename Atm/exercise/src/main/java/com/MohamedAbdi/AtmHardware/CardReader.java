package com.MohamedAbdi.AtmHardware;

public class CardReader {

    public String readCard() {
        // In a real ATM, this would interact with hardware.
        // For simulation, you can return a fixed card number or prompt the user to enter one.
        return "123456789"; // Example card number
    }

    public boolean validateCard(String cardNumber) {
        // Here, you might check if the card number matches a valid pattern or is in your database
        return cardNumber != null && !cardNumber.isEmpty();
        // In real-world, additional validations would be applied
    }
}