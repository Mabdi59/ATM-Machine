package com.MohamedAbdi.AtmHardware;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Printer {

    public void printReceipt(String receiptData) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = dateFormat.format(new Date());

        System.out.println("\n--- Receipt ---");
        System.out.println("Date/Time: " + dateTime);
        System.out.println(receiptData);
        System.out.println("--- End of Receipt ---\n");
        System.out.println("Receipt printed successfully.");
    }

}