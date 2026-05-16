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


    public static boolean isPositive(Number number) {
        if (number == null) return false;
        return number.doubleValue() > 0;
    }


    public static boolean isNegative(Number number) {
        if (number == null) return false;
        return number.doubleValue() < 0;
    }

    public static boolean isZero(Number number) {
        if (number == null) return false;
        return number.doubleValue() == 0;
    }

    public static Integer toInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return null;
        }
    }
    public static Long toLong(String value) {
        try {
            return Long.parseLong(value);
        } catch (Exception e) {
            return null;
        }
    }

    public static Double toDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            return null;
        }
    }

    public static BigDecimal toBigDecimal(String value) {
        try {
            return new BigDecimal(value);
        } catch (Exception e) {
            return null;
        }
    }

    public static double round(double value,int places) {
        return BigDecimal.valueOf(value).setScale(places, RoundingMode.HALF_UP).doubleValue();
    }

    public static String format(double value,String pattern) {
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(value);
    }

    public static String formatCurrency(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(value);
    }
    public static int randomInt(int min,int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static long randomLong(long min,long max) {
        return min +(long) (Math.random() * (max - min));
    }

    public static int generateOtp() {
        return randomInt(100000, 999999);
    }
    public static double percentage(double value,double total) {
        if (total == 0) return 0;
        return (value / total) * 100;
    }
    public static double discount(double amount,double percentage) {
        return amount * percentage / 100;
    }

    public static double add(double a,double b) {
        return BigDecimal.valueOf(a).add(BigDecimal.valueOf(b)).doubleValue();
    }
    public static double subtract(double a,double b) {
        return BigDecimal.valueOf(a).subtract(BigDecimal.valueOf(b)).doubleValue();
    }
    public static double multiply(double a,double b) {
        return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b)).doubleValue();
    }
    public static double divide(double a,double b) {
        if (b == 0) return 0;
        return BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b),2,RoundingMode.HALF_UP).doubleValue();
    }

    public static int max(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) return 0;
        return numbers.stream().max(Integer::compareTo).orElse(0);
    }

    public static int min(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) return 0;
        return numbers.stream().min(Integer::compareTo).orElse(0);
    }

    public static double average(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) return 0;
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public static int nullToZero(Integer value) {return value == null ? 0 : value;}
    public static boolean inRange(int value,int min,int max) {
        return value >= min && value <= max;
    }

    public static double bytesToKb(long bytes) {
        return round(bytes / 1024.0, 2);
    }

    public static double bytesToMb(long bytes) {
        return round(bytes / (1024.0 * 1024), 2);
    }

    public static double bytesToGb(long bytes) {
        return round(bytes / (1024.0 * 1024 * 1024), 2);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static long factorial(int number) {

        if (number < 0) return 0;
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}