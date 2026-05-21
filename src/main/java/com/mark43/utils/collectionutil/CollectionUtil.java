package com.mark43.utils.collectionutil;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class CollectionUtil {

    private CollectionUtil() {
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
    public static <T> List<T> emptyIfNull(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }
    public static <T> Set<T> emptyIfNull(Set<T> set) {
        return set == null ? Collections.emptySet() : set;
    }
    public static <K, V> Map<K, V> emptyIfNull(Map<K, V> map) {return map == null ? Collections.emptyMap() : map;}

    public static <T> Set<T> toSet(List<T> list) {
        if (isEmpty(list)) { return Collections.emptySet();}
        return new HashSet<>(list);
    }
    public static <T> List<T> toList(Set<T> set) {
        if (isEmpty(set)) { return Collections.emptyList();}
        return new ArrayList<>(set);
    }

    public static <T> T first(List<T> list) {
        if (isEmpty(list)) {return null;}
        return list.get(0);
    }

    public static <T> T last(List<T> list) {
        if (isEmpty(list)) {return null;}
        return list.get(list.size() - 1);
    }
    public static int size(Collection<?> collection) {
        return collection == null ? 0 : collection.size();
    }

    public static int size(Map<?, ?> map) {
        return map == null ? 0 : map.size();
    }
    public static <T> boolean contains(Collection<T> collection,T value) {
        return collection != null && collection.contains(value);
    }
    public static <T> List<T> removeDuplicates(List<T> list) {
        if (isEmpty(list)) {return Collections.emptyList();}
        return new ArrayList<>(new LinkedHashSet<>(list));
    }


    public static <T extends Comparable<? super T>> List<T> sortAsc(List<T> list) {
        if (isEmpty(list)) return Collections.emptyList();
        return list.stream().sorted().toList();
    }
    public static <T extends Comparable<? super T>> List<T> sortDesc(List<T> list) {
        if (isEmpty(list)) return Collections.emptyList();

        return list.stream().sorted(Comparator.reverseOrder()).toList();
    }
    public static <T> List<T> shuffle(List<T> list) {
        if (isEmpty(list)) return Collections.emptyList();
        List<T> shuffled = new ArrayList<>(list);
        Collections.shuffle(shuffled);
        return shuffled;
    }
}