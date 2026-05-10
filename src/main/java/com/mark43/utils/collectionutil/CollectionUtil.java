package com.mark43.utils.collectionutil;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class CollectionUtil {

    private CollectionUtil() {
    }

    /**
     * Check collection is null or empty
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Check collection is not empty
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * Check map is null or empty
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * Check map is not empty
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * Return empty list if null
     */
    public static <T> List<T> emptyIfNull(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    /**
     * Return empty set if null
     */
    public static <T> Set<T> emptyIfNull(Set<T> set) {
        return set == null ? Collections.emptySet() : set;
    }

    /**
     * Return empty map if null
     */
    public static <K, V> Map<K, V> emptyIfNull(
            Map<K, V> map
    ) {

        return map == null ? Collections.emptyMap() : map;
    }

    /**
     * Convert list to set
     */
    public static <T> Set<T> toSet(List<T> list) {

        if (isEmpty(list)) {
            return Collections.emptySet();
        }

        return new HashSet<>(list);
    }

    /**
     * Convert set to list
     */
    public static <T> List<T> toList(Set<T> set) {

        if (isEmpty(set)) {
            return Collections.emptyList();
        }

        return new ArrayList<>(set);
    }

    /**
     * Get first element
     */
    public static <T> T first(List<T> list) {

        if (isEmpty(list)) {
            return null;
        }

        return list.get(0);
    }

    /**
     * Get last element
     */
    public static <T> T last(List<T> list) {

        if (isEmpty(list)) {
            return null;
        }

        return list.get(list.size() - 1);
    }

    /**
     * Safe size
     */
    public static int size(Collection<?> collection) {
        return collection == null ? 0 : collection.size();
    }

    /**
     * Safe size for map
     */
    public static int size(Map<?, ?> map) {
        return map == null ? 0 : map.size();
    }

    /**
     * Check contains
     */
    public static <T> boolean contains(
            Collection<T> collection,
            T value
    ) {

        return collection != null
                && collection.contains(value);
    }

    /**
     * Remove duplicates
     */
    public static <T> List<T> removeDuplicates(
            List<T> list
    ) {

        if (isEmpty(list)) {
            return Collections.emptyList();
        }

        return new ArrayList<>(
                new LinkedHashSet<>(list)
        );
    }

    /**
     * Merge two lists
     */
    public static <T> List<T> merge(
            List<T> first,
            List<T> second
    ) {

        List<T> merged = new ArrayList<>();

        if (first != null) {
            merged.addAll(first);
        }

        if (second != null) {
            merged.addAll(second);
        }

        return merged;
    }

    /**
     * Split list into chunks
     */
    public static <T> List<List<T>> partition(
            List<T> list,
            int size
    ) {

        List<List<T>> partitions = new ArrayList<>();

        if (isEmpty(list) || size <= 0) {
            return partitions;
        }

        for (int i = 0; i < list.size(); i += size) {

            partitions.add(
                    list.subList(
                            i,
                            Math.min(i + size, list.size())
                    )
            );
        }

        return partitions;
    }

    /**
     * Convert collection to comma separated string
     */
    public static String join(
            Collection<?> collection
    ) {

        return join(collection, ", ");
    }

    /**
     * Convert collection to separated string
     */
    public static String join(
            Collection<?> collection,
            String delimiter
    ) {

        if (isEmpty(collection)) {
            return "";
        }

        return collection.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(delimiter));
    }

    /**
     * Sort list ascending
     */
    public static <T extends Comparable<? super T>>
    List<T> sortAsc(List<T> list) {

        if (isEmpty(list)) {
            return Collections.emptyList();
        }

        return list.stream()
                .sorted()
                .toList();
    }

    /**
     * Sort list descending
     */
    public static <T extends Comparable<? super T>>
    List<T> sortDesc(List<T> list) {

        if (isEmpty(list)) {
            return Collections.emptyList();
        }

        return list.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    /**
     * Convert list to map
     */
    public static <T, K> Map<K, T> toMap(
            List<T> list,
            Function<T, K> keyMapper
    ) {

        if (isEmpty(list)) {
            return Collections.emptyMap();
        }

        return list.stream()
                .collect(Collectors.toMap(
                        keyMapper,
                        Function.identity()
                ));
    }

    /**
     * Shuffle list
     */
    public static <T> List<T> shuffle(
            List<T> list
    ) {

        if (isEmpty(list)) {
            return Collections.emptyList();
        }

        List<T> shuffled = new ArrayList<>(list);

        Collections.shuffle(shuffled);

        return shuffled;
    }

    /**
     * Reverse list
     */
    public static <T> List<T> reverse(
            List<T> list
    ) {

        if (isEmpty(list)) {
            return Collections.emptyList();
        }

        List<T> reversed = new ArrayList<>(list);

        Collections.reverse(reversed);

        return reversed;
    }

    /**
     * Immutable list
     */
    public static <T> List<T> immutableList(
            List<T> list
    ) {

        return list == null
                ? List.of()
                : List.copyOf(list);
    }

    /**
     * Immutable set
     */
    public static <T> Set<T> immutableSet(
            Set<T> set
    ) {

        return set == null
                ? Set.of()
                : Set.copyOf(set);
    }

    /**
     * Immutable map
     */
    public static <K, V> Map<K, V> immutableMap(
            Map<K, V> map
    ) {

        return map == null
                ? Map.of()
                : Map.copyOf(map);
    }

    /**
     * Get random element
     */
    public static <T> T random(
            List<T> list
    ) {

        if (isEmpty(list)) {
            return null;
        }

        Random random = new Random();

        return list.get(
                random.nextInt(list.size())
        );
    }
}