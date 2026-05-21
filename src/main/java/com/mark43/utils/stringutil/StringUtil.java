package com.mark43.utils.stringutil;

import java.text.Normalizer;
import java.util.UUID;
import java.util.regex.Pattern;

public final class StringUtil {

    private StringUtil() {
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isNotEmpty(String value) {
        return !isNullOrEmpty(value);
    }

    public static String trim(String value) {
        return value == null ? null : value.trim();
    }

    public static String capitalize(String value) {
        if (isNullOrEmpty(value)) return value;
        return value.substring(0, 1).toUpperCase()
                + value.substring(1).toLowerCase();
    }

    public static String unCapitalize(String value) {
        if (isNullOrEmpty(value)) return value;
        return value.substring(0, 1).toLowerCase() + value.substring(1);
    }

    public static String toSlug(String value) {
        if (isNullOrEmpty(value)) return "";
        String normalized = Normalizer.normalize(value,Normalizer.Form.NFD);
        return normalized.replaceAll("[^\\w\\s-]", "").trim()
                .replaceAll("\\s+", "-")
                .replaceAll("-+", "-")
                .toLowerCase();
    }

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static String generateShortUUID() {
        return UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 10);
    }



    public static String removeSpaces(String value) {
        if (value == null) return null;
        return value.replaceAll("\\s+", "");
    }
    public static String nullToEmpty(String value) {
        return value == null ? "" : value;
    }
    public static boolean isNumeric(String value) {
        if (isNullOrEmpty(value)) return false;
        return value.matches("\\d+");
    }

    public static boolean isAlphabetic(String value) {
        if (isNullOrEmpty(value)) return false;
        return value.matches("[a-zA-Z]+");
    }
    public static boolean isValidEmail(String email) {
        if (isNullOrEmpty(email)) return false;
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(regex, email);
    }

    public static boolean isValidPhone(String phone) {
        if (isNullOrEmpty(phone)) return false;
        return phone.matches("^[6-9]\\d{9}$");
    }

    public static String maskEmail(String email) {
        if (!isValidEmail(email)) return email;
        int index = email.indexOf("@");
        String firstPart = email.substring(0, index);
        if (firstPart.length() <= 2) return email;
        return firstPart.substring(0, 2) + "******" + email.substring(index);
    }

    public static String maskPhone(String phone) {
        if (!isValidPhone(phone)) return phone;
        return "******" + phone.substring(6);
    }





    public static String toUpperCase(String value) {
        return value == null ? null : value.toUpperCase();
    }

    public static String toLowerCase(String value) {
        return value == null ? null : value.toLowerCase();
    }

    public static String getInitials(String name) {
        if (isNullOrEmpty(name)) return "";

        String[] words = name.trim().split("\\s+");
        StringBuilder initials = new StringBuilder();
        for (String word : words) {
            initials.append(Character.toUpperCase(word.charAt(0)));
        }

        return initials.toString();
    }
}
