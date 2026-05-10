package com.mark43.utils.response;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public final class ResponseUtil {

    private ResponseUtil() {
    }

    /**
     * Success Response
     */
    public static <T> ResponseEntity<ApiResponse<T>> success(
            String message,
            T data
    ) {

        ApiResponse<T> response =
                ApiResponse.<T>builder()
                        .success(true)
                        .message(message)
                        .data(data)
                        .status(HttpStatus.OK.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return ResponseEntity.ok(response);
    }

    /**
     * Success Response with custom status
     */
    public static <T> ResponseEntity<ApiResponse<T>> success(
            String message,
            T data,
            HttpStatus status
    ) {

        ApiResponse<T> response =
                ApiResponse.<T>builder()
                        .success(true)
                        .message(message)
                        .data(data)
                        .status(status.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(response, status);
    }

    /**
     * Created Response
     */
    public static <T> ResponseEntity<ApiResponse<T>> created(
            String message,
            T data
    ) {

        ApiResponse<T> response =
                ApiResponse.<T>builder()
                        .success(true)
                        .message(message)
                        .data(data)
                        .status(HttpStatus.CREATED.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );
    }

    /**
     * Error Response
     */
    public static <T> ResponseEntity<ApiResponse<T>> error(
            String message
    ) {

        ApiResponse<T> response =
                ApiResponse.<T>builder()
                        .success(false)
                        .message(message)
                        .status(HttpStatus.BAD_REQUEST.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST
        );
    }

    /**
     * Error Response with custom status
     */
    public static <T> ResponseEntity<ApiResponse<T>> error(
            String message,
            HttpStatus status
    ) {

        ApiResponse<T> response =
                ApiResponse.<T>builder()
                        .success(false)
                        .message(message)
                        .status(status.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(
                response,
                status
        );
    }

    /**
     * Unauthorized Response
     */
    public static <T> ResponseEntity<ApiResponse<T>> unauthorized(
            String message
    ) {

        ApiResponse<T> response =
                ApiResponse.<T>builder()
                        .success(false)
                        .message(message)
                        .status(HttpStatus.UNAUTHORIZED.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(
                response,
                HttpStatus.UNAUTHORIZED
        );
    }

    /**
     * Forbidden Response
     */
    public static <T> ResponseEntity<ApiResponse<T>> forbidden(
            String message
    ) {

        ApiResponse<T> response =
                ApiResponse.<T>builder()
                        .success(false)
                        .message(message)
                        .status(HttpStatus.FORBIDDEN.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(
                response,
                HttpStatus.FORBIDDEN
        );
    }

    /**
     * Not Found Response
     */
    public static <T> ResponseEntity<ApiResponse<T>> notFound(
            String message
    ) {

        ApiResponse<T> response =
                ApiResponse.<T>builder()
                        .success(false)
                        .message(message)
                        .status(HttpStatus.NOT_FOUND.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND
        );
    }

    /**
     * Validation Error Response
     */
    public static <T> ResponseEntity<ApiResponse<T>> validationError(
            String message
    ) {

        ApiResponse<T> response =
                ApiResponse.<T>builder()
                        .success(false)
                        .message(message)
                        .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(
                response,
                HttpStatus.UNPROCESSABLE_ENTITY
        );
    }

    /**
     * Internal Server Error Response
     */
    public static <T> ResponseEntity<ApiResponse<T>> internalServerError(
            String message
    ) {

        ApiResponse<T> response =
                ApiResponse.<T>builder()
                        .success(false)
                        .message(message)
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(
                response,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}