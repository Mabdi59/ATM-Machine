package com.MohamedAbdi.AtmHardware;

public class CashDispenser {

    private int cashAvailable;

    public CashDispenser() {
        this.cashAvailable = 10000;
    }

    public boolean dispenseCash(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount specified.");
            return false;
        }

        if (amount <= cashAvailable) {
            cashAvailable -= amount;
            System.out.println("Dispensing cash: $" + amount);
            return true;
        } else {
            System.out.println("Insufficient cash available in the dispenser.");
            return false;
        }
    }

    public void reloadCash(int amount) {
        if (amount > 0) {
            cashAvailable += amount;
            System.out.println("Cash dispenser reloaded with: $" + amount);
        }
    }

    public int getCashAvailable() {
        return cashAvailable;
    }
}