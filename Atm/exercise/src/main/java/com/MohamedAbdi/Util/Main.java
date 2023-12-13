package com.MohamedAbdi.Util;


import com.MohamedAbdi.Util.Configuration;
import com.MohamedAbdi.Util.Logger;
import com.MohamedAbdi.Util.Utility;

public class Main {
    public static void main(String[] args) {
        // Demonstrate Configuration usage
        Configuration config = new Configuration("config.txt");
        String someSetting = config.getSetting("someKey");
        System.out.println("Configured Setting: " + someSetting);

        // Demonstrate Logger usage
        Logger.log("Starting ATM application");

        // Demonstrate Utility usage
        double sampleAmount = 123.45;
        String formattedAmount = Utility.formatCurrency(sampleAmount);
        System.out.println("Formatted amount: " + formattedAmount);
        String currentDateTime = Utility.getCurrentDateTime();
        System.out.println("Current Date Time: " + currentDateTime);

        Logger.log("ATM application finished");
    }
}