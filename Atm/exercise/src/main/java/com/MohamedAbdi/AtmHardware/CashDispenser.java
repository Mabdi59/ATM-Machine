package com.MohamedAbdi.AtmHardware;

public class CashDispenser {

    private int cashAvailable;

    public CashDispenser() {
        this.cashAvailable = 10000; // Initial cash loaded in the dispenser
    }

    public boolean dispenseCash(int amount) {
        if (amount <= cashAvailable) {
            cashAvailable -= amount;
            System.out.println("Dispensing cash: $" + amount);
            return true;
        } else {
            System.out.println("Insufficient cash available in the dispenser.");
            return false;
        }
    }

    public int getCashAvailable() {
        return cashAvailable;
    }
}
