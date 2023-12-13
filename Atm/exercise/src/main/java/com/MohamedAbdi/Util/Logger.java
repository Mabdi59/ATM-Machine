package com.MohamedAbdi.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static final String LOG_FILE_NAME = "ATM_Log.txt";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    public static void log(String message) {
        String timestamp = dateFormat.format(new Date());
        String logEntry = timestamp + " - " + message + "\n";

        try (FileWriter writer = new FileWriter(LOG_FILE_NAME, true)) {
            writer.append(logEntry);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}