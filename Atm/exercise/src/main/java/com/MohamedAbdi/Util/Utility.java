package com.MohamedAbdi.Util;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    // Method to format currency
    public static String formatCurrency(double amount) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        return currencyFormat.format(amount);
    }

    // Method to get the current date and time as a formatted string
    public static String getCurrentDateTime() {
        return dateFormat.format(new Date());
    }
}