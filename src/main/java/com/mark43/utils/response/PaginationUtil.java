package com.mark43.utils.response;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public final class PaginationUtil {

    private PaginationUtil() {
    }

    /**
     * Default page number
     */
    public static final int DEFAULT_PAGE = 0;

    /**
     * Default page size
     */
    public static final int DEFAULT_SIZE = 10;

    /**
     * Max page size
     */
    public static final int MAX_PAGE_SIZE = 100;

    /**
     * Create pageable with sorting
     */
    public static Pageable pageable(
            Integer page,
            Integer size,
            String sortBy,
            String direction
    ) {

        int pageNumber =
                page == null || page < 0
                        ? DEFAULT_PAGE
                        : page;

        int pageSize =
                size == null || size <= 0
                        ? DEFAULT_SIZE
                        : Math.min(size, MAX_PAGE_SIZE);

        String sortField =
                sortBy == null || sortBy.isBlank()
                        ? "createdAt"
                        : sortBy;

        Sort sort = "asc".equalsIgnoreCase(direction)
                ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();

        return PageRequest.of(
                pageNumber,
                pageSize,
                sort
        );
    }

    /**
     * Create pageable without sorting
     */
    public static Pageable pageable(
            Integer page,
            Integer size
    ) {

        int pageNumber =
                page == null || page < 0
                        ? DEFAULT_PAGE
                        : page;

        int pageSize =
                size == null || size <= 0
                        ? DEFAULT_SIZE
                        : Math.min(size, MAX_PAGE_SIZE);

        return PageRequest.of(
                pageNumber,
                pageSize
        );
    }

    /**
     * Create ascending sort pageable
     */
    public static Pageable asc(
            Integer page,
            Integer size,
            String sortBy
    ) {

        return pageable(
                page,
                size,
                sortBy,
                "asc"
        );
    }

    /**
     * Create descending sort pageable
     */
    public static Pageable desc(
            Integer page,
            Integer size,
            String sortBy
    ) {

        return pageable(
                page,
                size,
                sortBy,
                "desc"
        );
    }

    /**
     * Convert page content to list
     */
    public static <T> List<T> getContent(
            Page<T> page
    ) {

        return page == null
                ? List.of()
                : page.getContent();
    }

    /**
     * Get total pages
     */
    public static int totalPages(Page<?> page) {

        return page == null
                ? 0
                : page.getTotalPages();
    }

    /**
     * Get total elements
     */
    public static long totalElements(Page<?> page) {

        return page == null
                ? 0
                : page.getTotalElements();
    }

    /**
     * Check has next page
     */
    public static boolean hasNext(Page<?> page) {

        return page != null
                && page.hasNext();
    }

    /**
     * Check has previous page
     */
    public static boolean hasPrevious(Page<?> page) {

        return page != null
                && page.hasPrevious();
    }

    /**
     * Check page is empty
     */
    public static boolean isEmpty(Page<?> page) {

        return page == null
                || page.isEmpty();
    }

    /**
     * Check page is not empty
     */
    public static boolean isNotEmpty(Page<?> page) {

        return !isEmpty(page);
    }

    /**
     * Get current page number
     */
    public static int currentPage(Page<?> page) {

        return page == null
                ? 0
                : page.getNumber();
    }

    /**
     * Get current page size
     */
    public static int currentSize(Page<?> page) {

        return page == null
                ? 0
                : page.getSize();
    }

    /**
     * Create sort object
     */
    public static Sort sort(
            String sortBy,
            String direction
    ) {

        String field =
                sortBy == null || sortBy.isBlank()
                        ? "createdAt"
                        : sortBy;

        return "asc".equalsIgnoreCase(direction)
                ? Sort.by(field).ascending()
                : Sort.by(field).descending();
    }
}