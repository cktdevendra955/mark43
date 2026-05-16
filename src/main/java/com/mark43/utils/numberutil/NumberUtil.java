package com.mark43.utils.numberutil;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

public final class NumberUtil {

    private NumberUtil() {
    }

    public static boolean isNull(Number number) {
        return number == null;
    }

    public static boolean isNotNull(Number number) {
        return number != null;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    /**
     * Check number is positive
     */
    public static boolean isPositive(Number number) {

        if (number == null) {
            return false;
        }

        return number.doubleValue() > 0;
    }

    /**
     * Check number is negative
     */
    public static boolean isNegative(Number number) {

        if (number == null) {
            return false;
        }

        return number.doubleValue() < 0;
    }

    /**
     * Check number is zero
     */
    public static boolean isZero(Number number) {

        if (number == null) {
            return false;
        }

        return number.doubleValue() == 0;
    }

    /**
     * Convert string to integer safely
     */
    public static Integer toInteger(String value) {

        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Convert string to long safely
     */
    public static Long toLong(String value) {

        try {
            return Long.parseLong(value);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Convert string to double safely
     */
    public static Double toDouble(String value) {

        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Convert string to BigDecimal safely
     */
    public static BigDecimal toBigDecimal(
            String value
    ) {

        try {
            return new BigDecimal(value);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Round decimal value
     */
    public static double round(
            double value,
            int places
    ) {

        return BigDecimal.valueOf(value)
                .setScale(places, RoundingMode.HALF_UP)
                .doubleValue();
    }

    /**
     * Format decimal number
     */
    public static String format(
            double value,
            String pattern
    ) {

        DecimalFormat decimalFormat =
                new DecimalFormat(pattern);

        return decimalFormat.format(value);
    }

    /**
     * Format currency
     */
    public static String formatCurrency(
            double value
    ) {

        DecimalFormat decimalFormat =
                new DecimalFormat("#,##0.00");

        return decimalFormat.format(value);
    }

    /**
     * Generate random integer
     */
    public static int randomInt(
            int min,
            int max
    ) {

        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Generate random long
     */
    public static long randomLong(
            long min,
            long max
    ) {

        return min +
                (long) (Math.random() * (max - min));
    }

    /**
     * Generate OTP
     */
    public static int generateOtp() {
        return randomInt(100000, 999999);
    }

    /**
     * Calculate percentage
     */
    public static double percentage(
            double value,
            double total
    ) {

        if (total == 0) {
            return 0;
        }

        return (value / total) * 100;
    }

    /**
     * Calculate discount amount
     */
    public static double discount(
            double amount,
            double percentage
    ) {

        return amount * percentage / 100;
    }

    /**
     * Add numbers safely
     */
    public static double add(
            double a,
            double b
    ) {

        return BigDecimal.valueOf(a)
                .add(BigDecimal.valueOf(b))
                .doubleValue();
    }

    /**
     * Subtract numbers safely
     */
    public static double subtract(
            double a,
            double b
    ) {

        return BigDecimal.valueOf(a)
                .subtract(BigDecimal.valueOf(b))
                .doubleValue();
    }

    /**
     * Multiply numbers safely
     */
    public static double multiply(
            double a,
            double b
    ) {

        return BigDecimal.valueOf(a)
                .multiply(BigDecimal.valueOf(b))
                .doubleValue();
    }

    /**
     * Divide numbers safely
     */
    public static double divide(
            double a,
            double b
    ) {

        if (b == 0) {
            return 0;
        }

        return BigDecimal.valueOf(a)
                .divide(
                        BigDecimal.valueOf(b),
                        2,
                        RoundingMode.HALF_UP
                )
                .doubleValue();
    }

    /**
     * Get maximum value
     */
    public static int max(List<Integer> numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        return numbers.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    /**
     * Get minimum value
     */
    public static int min(List<Integer> numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        return numbers.stream()
                .min(Integer::compareTo)
                .orElse(0);
    }

    /**
     * Get average value
     */
    public static double average(
            List<Integer> numbers
    ) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    /**
     * Convert null to zero
     */
    public static int nullToZero(Integer value) {
        return value == null ? 0 : value;
    }

    /**
     * Check number in range
     */
    public static boolean inRange(
            int value,
            int min,
            int max
    ) {

        return value >= min && value <= max;
    }

    /**
     * Convert bytes to KB
     */
    public static double bytesToKb(long bytes) {
        return round(bytes / 1024.0, 2);
    }

    /**
     * Convert bytes to MB
     */
    public static double bytesToMb(long bytes) {
        return round(bytes / (1024.0 * 1024), 2);
    }

    /**
     * Convert bytes to GB
     */
    public static double bytesToGb(long bytes) {
        return round(bytes / (1024.0 * 1024 * 1024), 2);
    }

    /**
     * Check prime number
     */
    public static boolean isPrime(int number) {

        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {

            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Calculate factorial
     */
    public static long factorial(int number) {

        if (number < 0) {
            return 0;
        }

        long factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        return factorial;
    }
}