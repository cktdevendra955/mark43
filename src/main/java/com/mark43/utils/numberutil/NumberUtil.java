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


    public static boolean isPositive(Number number) {
        if (number == null) return false;
        return number.doubleValue() > 0;
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
    public static double percentage(double value,double total) {
        if (total == 0) return 0;
        return (value / total) * 100;
    }
    public static double discount(double amount,double percentage) {
        return amount * percentage / 100;
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


}