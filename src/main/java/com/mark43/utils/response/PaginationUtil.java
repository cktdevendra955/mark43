package com.mark43.utils.response;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public final class PaginationUtil {

    private PaginationUtil() {
    }

    public static final int DEFAULT_PAGE = 0;

    public static final int DEFAULT_SIZE = 10;
    public static final int MAX_PAGE_SIZE = 100;

    public static Pageable pageable(Integer page,Integer size,String sortBy,String direction) {
        int pageNumber = page == null || page < 0 ? DEFAULT_PAGE : page;
        int pageSize = size == null || size <= 0 ? DEFAULT_SIZE : Math.min(size, MAX_PAGE_SIZE);
        String sortField = sortBy == null || sortBy.isBlank() ? "createdAt" : sortBy;
        Sort sort = "asc".equalsIgnoreCase(direction)
                ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();
        return PageRequest.of(pageNumber,pageSize,sort);
    }


    public static Pageable pageable(Integer page,Integer size) {
        int pageNumber =page == null || page < 0? DEFAULT_PAGE: page;
        int pageSize =size == null || size <= 0? DEFAULT_SIZE: Math.min(size, MAX_PAGE_SIZE);
        return PageRequest.of(pageNumber,pageSize);
    }

    public static Pageable asc(Integer page,Integer size,String sortBy) {
        return pageable(page,size,sortBy,"asc");
    }

    public static Pageable desc(Integer page,Integer size,String sortBy) {
        return pageable(page,size,sortBy,"desc");
    }

    public static <T> List<T> getContent(Page<T> page) {
        return page == null? List.of(): page.getContent();
    }
    public static int totalPages(Page<?> page) {
        return page == null? 0: page.getTotalPages();
    }
    public static long totalElements(Page<?> page) {
        return page == null? 0: page.getTotalElements();
    }
    public static boolean hasNext(Page<?> page) {
        return page != null && page.hasNext();
    }
    public static boolean hasPrevious(Page<?> page) {
        return page != null && page.hasPrevious();
    }

    public static boolean isEmpty(Page<?> page) {
        return page == null || page.isEmpty();
    }
    public static boolean isNotEmpty(Page<?> page) {
        return !isEmpty(page);
    }
    public static int currentPage(Page<?> page) {
        return page == null ? 0 : page.getNumber();
    }
    public static int currentSize(Page<?> page) {
        return page == null ? 0 : page.getSize();
    }

    public static Sort sort(String sortBy,String direction) {
        String field = sortBy == null || sortBy.isBlank() ? "createdAt" : sortBy;
        return "asc".equalsIgnoreCase(direction) ? Sort.by(field).ascending() : Sort.by(field).descending();
    }
}