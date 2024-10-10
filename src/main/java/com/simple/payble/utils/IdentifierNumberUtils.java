package com.simple.payble.utils;

public class IdentifierNumberUtils {

    public static String sanitize(String uniqueIdentifierNumber){
        String sanitizePattern = "[^a-zA-Z0-9]";

        return uniqueIdentifierNumber.replaceAll(sanitizePattern, "");
    }
}
