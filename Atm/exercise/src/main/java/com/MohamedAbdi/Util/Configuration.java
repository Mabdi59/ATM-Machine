package com.MohamedAbdi.Util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private Map<String, String> settings;

    public Configuration(String s) {
        settings = new HashMap<>();
        loadConfiguration();
    }

    private void loadConfiguration() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) continue;
                String[] parts = line.split("=", 2);
                settings.put(parts[0].trim(), parts[1].trim());
            }
        } catch (Exception e) {
            System.err.println("Error reading configuration file: " + e.getMessage());
        }
    }

    public String getSetting(String key) {
        return settings.get(key);
    }
}