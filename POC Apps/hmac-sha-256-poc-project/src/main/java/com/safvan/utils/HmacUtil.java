package com.safvan.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class HmacUtil {

    public static String calculateHmacSHA256(String key, String data) {
        try {
            // Create an HMAC-SHA256 key from the provided key string
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");

            // Initialize the HMAC-SHA256 instance with the key
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);

            // Calculate the HMAC-SHA256 hash
            byte[] hmacBytes = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));

            // Convert the result to a hexadecimal string
            return bytesToHex(hmacBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error calculating HMAC-SHA256", e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
