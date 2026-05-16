package com.mark43.utils.datetimeutil;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public final class DateTimeUtil {

    private DateTimeUtil() {
    }

    /**
     * Default date format
     */
    public static final String DEFAULT_DATE_FORMAT = "dd-MM-yyyy";

    /**
     * Default datetime format
     */
    public static final String DEFAULT_DATE_TIME_FORMAT =
            "dd-MM-yyyy HH:mm:ss";

    /**
     * Current LocalDateTime
     */
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    /**
     * Current LocalDate
     */
    public static LocalDate today() {
        return LocalDate.now();
    }

    /**
     * Current LocalTime
     */
    public static LocalTime currentTime() {
        return LocalTime.now();
    }

    /**
     * Get current timestamp
     */
    public static Instant currentTimestamp() {
        return Instant.now();
    }

    /**
     * Format LocalDate
     */
    public static String format(
            LocalDate date,
            String pattern
    ) {

        if (date == null) {
            return null;
        }

        return date.format(
                DateTimeFormatter.ofPattern(pattern)
        );
    }

    /**
     * Format LocalDateTime
     */
    public static String format(
            LocalDateTime dateTime,
            String pattern
    ) {

        if (dateTime == null) {
            return null;
        }

        return dateTime.format(
                DateTimeFormatter.ofPattern(pattern)
        );
    }

    /**
     * Format using default date format
     */
    public static String formatDate(LocalDate date) {
        return format(date, DEFAULT_DATE_FORMAT);
    }

    /**
     * Format using default datetime format
     */
    public static String formatDateTime(
            LocalDateTime dateTime
    ) {
        return format(dateTime, DEFAULT_DATE_TIME_FORMAT);
    }

    /**
     * Parse LocalDate
     */
    public static LocalDate parseDate(
            String date,
            String pattern
    ) {

        if (date == null || date.isBlank()) {
            return null;
        }

        return LocalDate.parse(
                date,
                DateTimeFormatter.ofPattern(pattern)
        );
    }

    /**
     * Parse LocalDateTime
     */
    public static LocalDateTime parseDateTime(
            String dateTime,
            String pattern
    ) {

        if (dateTime == null || dateTime.isBlank()) {
            return null;
        }

        return LocalDateTime.parse(
                dateTime,
                DateTimeFormatter.ofPattern(pattern)
        );
    }

    /**
     * Convert Date to LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(Date date) {

        if (date == null) {
            return null;
        }

        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    /**
     * Convert LocalDateTime to Date
     */
    public static Date toDate(LocalDateTime dateTime) {

        if (dateTime == null) {
            return null;
        }

        return Date.from(
                dateTime.atZone(ZoneId.systemDefault())
                        .toInstant()
        );
    }

    /**
     * Add days
     */
    public static LocalDateTime addDays(
            LocalDateTime dateTime,
            long days
    ) {

        return dateTime.plusDays(days);
    }

    /**
     * Add months
     */
    public static LocalDateTime addMonths(
            LocalDateTime dateTime,
            long months
    ) {

        return dateTime.plusMonths(months);
    }

    /**
     * Add years
     */
    public static LocalDateTime addYears(
            LocalDateTime dateTime,
            long years
    ) {

        return dateTime.plusYears(years);
    }

    /**
     * Subtract days
     */
    public static LocalDateTime subtractDays(
            LocalDateTime dateTime,
            long days
    ) {

        return dateTime.minusDays(days);
    }

    /**
     * Get difference in days
     */
    public static long differenceInDays(
            LocalDate startDate,
            LocalDate endDate
    ) {

        return ChronoUnit.DAYS.between(
                startDate,
                endDate
        );
    }

    /**
     * Get difference in hours
     */
    public static long differenceInHours(
            LocalDateTime start,
            LocalDateTime end
    ) {

        return ChronoUnit.HOURS.between(
                start,
                end
        );
    }

    /**
     * Get difference in minutes
     */
    public static long differenceInMinutes(
            LocalDateTime start,
            LocalDateTime end
    ) {

        return ChronoUnit.MINUTES.between(
                start,
                end
        );
    }

    /**
     * Check date is before
     */
    public static boolean isBefore(
            LocalDateTime source,
            LocalDateTime target
    ) {

        return source.isBefore(target);
    }

    /**
     * Check date is after
     */
    public static boolean isAfter(
            LocalDateTime source,
            LocalDateTime target
    ) {

        return source.isAfter(target);
    }

    /**
     * Check date is today
     */
    public static boolean isToday(LocalDate date) {

        return LocalDate.now().equals(date);
    }

    /**
     * Start of day
     */
    public static LocalDateTime startOfDay(
            LocalDate date
    ) {

        return date.atStartOfDay();
    }

    /**
     * End of day
     */
    public static LocalDateTime endOfDay(
            LocalDate date
    ) {

        return date.atTime(LocalTime.MAX);
    }
    public static int calculateAge(LocalDate dob) {
        if (dob == null) return 0;
        return Period.between(dob,LocalDate.now()).getYears();
    }

    public static long toEpochMilli(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static LocalDateTime fromEpochMilli(long epochMilli) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli),ZoneId.systemDefault());
    }

    public static LocalDateTime utcNow() {return LocalDateTime.now(ZoneOffset.UTC);}

    public static boolean isLeapYear(int year) {
        return Year.isLeap(year);
    }
    public static OffsetDateTime currentUtcDateTime() {
        return OffsetDateTime.now(ZoneOffset.UTC);
    }
}