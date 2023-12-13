package com.MohamedAbdi.Security;

import java.util.Base64;

public class EncryptionUtil {

    public static String encrypt(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    public static String decrypt(String encryptedData) {
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        return new String(decodedBytes);
    }
}