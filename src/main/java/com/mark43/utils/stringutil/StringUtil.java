package com.mark43.utils.stringutil;

import java.text.Normalizer;
import java.util.UUID;
import java.util.regex.Pattern;

public final class StringUtil {

    private StringUtil() {
    }

    /**
     * Check string is null or empty
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Check string has value
     */
    public static boolean isNotEmpty(String value) {
        return !isNullOrEmpty(value);
    }

    /**
     * Trim string safely
     */
    public static String trim(String value) {
        return value == null ? null : value.trim();
    }

    /**
     * Convert first letter to uppercase
     */
    public static String capitalize(String value) {

        if (isNullOrEmpty(value)) {
            return value;
        }

        return value.substring(0, 1).toUpperCase()
                + value.substring(1).toLowerCase();
    }

    /**
     * Convert first letter to lowercase
     */
    public static String unCapitalize(String value) {

        if (isNullOrEmpty(value)) {
            return value;
        }

        return value.substring(0, 1).toLowerCase()
                + value.substring(1);
    }

    /**
     * Convert to slug
     */
    public static String toSlug(String value) {

        if (isNullOrEmpty(value)) {
            return "";
        }

        String normalized = Normalizer.normalize(
                value,
                Normalizer.Form.NFD
        );

        return normalized
                .replaceAll("[^\\w\\s-]", "")
                .trim()
                .replaceAll("\\s+", "-")
                .replaceAll("-+", "-")
                .toLowerCase();
    }

    /**
     * Generate UUID
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * Generate short UUID
     */
    public static String generateShortUUID() {
        return UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 10);
    }

    /**
     * Reverse string
     */
    public static String reverse(String value) {

        if (value == null) {
            return null;
        }

        return new StringBuilder(value).reverse().toString();
    }

    /**
     * Remove all spaces
     */
    public static String removeSpaces(String value) {

        if (value == null) {
            return null;
        }

        return value.replaceAll("\\s+", "");
    }

    /**
     * Convert null to empty string
     */
    public static String nullToEmpty(String value) {
        return value == null ? "" : value;
    }

    /**
     * Check contains only numbers
     */
    public static boolean isNumeric(String value) {

        if (isNullOrEmpty(value)) {
            return false;
        }

        return value.matches("\\d+");
    }

    /**
     * Check contains only alphabets
     */
    public static boolean isAlphabetic(String value) {

        if (isNullOrEmpty(value)) {
            return false;
        }

        return value.matches("[a-zA-Z]+");
    }

    /**
     * Check valid email
     */
    public static boolean isValidEmail(String email) {

        if (isNullOrEmpty(email)) {
            return false;
        }

        String regex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        return Pattern.matches(regex, email);
    }

    /**
     * Check valid phone number
     */
    public static boolean isValidPhone(String phone) {

        if (isNullOrEmpty(phone)) {
            return false;
        }

        return phone.matches("^[6-9]\\d{9}$");
    }

    /**
     * Mask email
     */
    public static String maskEmail(String email) {

        if (!isValidEmail(email)) {
            return email;
        }

        int index = email.indexOf("@");

        String firstPart = email.substring(0, index);

        if (firstPart.length() <= 2) {
            return email;
        }

        return firstPart.substring(0, 2)
                + "******"
                + email.substring(index);
    }

    /**
     * Mask mobile number
     */
    public static String maskPhone(String phone) {

        if (!isValidPhone(phone)) {
            return phone;
        }

        return "******" + phone.substring(6);
    }

    /**
     * Repeat string
     */
    public static String repeat(String value, int count) {

        if (value == null || count <= 0) {
            return "";
        }

        return value.repeat(count);
    }

    /**
     * Safe equals
     */
    public static boolean equals(String s1, String s2) {

        if (s1 == null && s2 == null) {
            return true;
        }

        if (s1 == null || s2 == null) {
            return false;
        }

        return s1.equals(s2);
    }

    /**
     * Safe equals ignore case
     */
    public static boolean equalsIgnoreCase(
            String s1,
            String s2
    ) {

        if (s1 == null && s2 == null) {
            return true;
        }

        if (s1 == null || s2 == null) {
            return false;
        }

        return s1.equalsIgnoreCase(s2);
    }

    /**
     * Convert to uppercase safely
     */
    public static String toUpperCase(String value) {
        return value == null ? null : value.toUpperCase();
    }

    /**
     * Convert to lowercase safely
     */
    public static String toLowerCase(String value) {
        return value == null ? null : value.toLowerCase();
    }

    /**
     * Get initials from name
     */
    public static String getInitials(String name) {

        if (isNullOrEmpty(name)) {
            return "";
        }

        String[] words = name.trim().split("\\s+");

        StringBuilder initials = new StringBuilder();

        for (String word : words) {
            initials.append(
                    Character.toUpperCase(word.charAt(0))
            );
        }

        return initials.toString();
    }
}
