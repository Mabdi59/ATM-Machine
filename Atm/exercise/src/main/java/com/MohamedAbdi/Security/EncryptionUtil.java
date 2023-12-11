package com.MohamedAbdi.Security;

import java.util.Base64;

public class EncryptionUtil {

    // Simple encryption method (for example purposes only)
    public static String encrypt(String data) {
        // In a real application, use a more secure encryption method
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    // Simple decryption method
    public static String decrypt(String encryptedData) {
        // In a real application, use a corresponding decryption method
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        return new String(decodedBytes);
    }
}