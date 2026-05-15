package com.mark43.utils.response;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public final class ResponseUtils {

        /*
         * COMMON
         */
        public static final String SUCCESS = "Success";
        public static final String FAILED = "Failed";
        public static final String SOMETHING_WENT_WRONG = "Something went wrong";
        public static final String INVALID_REQUEST = "Invalid request";
        public static final String INTERNAL_SERVER_ERROR = "Internal server error";

        /*
         * CREATE
         */
        public static final String CREATED_SUCCESSFULLY = "Created successfully";
        public static final String RECORD_CREATED_SUCCESSFULLY = "Record created successfully";

        /*
         * UPDATE
         */
        public static final String UPDATED_SUCCESSFULLY = "Updated successfully";
        public static final String RECORD_UPDATED_SUCCESSFULLY = "Record updated successfully";

        /*
         * DELETE
         */
        public static final String DELETED_SUCCESSFULLY = "Deleted successfully";
        public static final String RECORD_DELETED_SUCCESSFULLY = "Record deleted successfully";
        public static final String RECORD_NOT_FOUND = "Record not found";

        /*
         * FETCH
         */
        public static final String FETCHED_SUCCESSFULLY = "Fetched successfully";
        public static final String DATA_FOUND = "Data found";
        public static final String NO_DATA_FOUND = "No data found";

        /*
         * AUTH
         */
        public static final String LOGIN_SUCCESSFUL = "Login successful";
        public static final String LOGIN_FAILED = "Login failed";
        public static final String INVALID_CREDENTIALS = "Invalid credentials";
        public static final String UNAUTHORIZED = "Unauthorized access";
        public static final String ACCESS_DENIED = "Access denied";
        public static final String TOKEN_EXPIRED = "Token expired";
        public static final String TOKEN_INVALID = "Invalid token";

        /*
         * USER
         */
        public static final String USER_NOT_FOUND = "User not found";
        public static final String USER_ALREADY_EXISTS = "User already exists";

        /*
         * VALIDATION
         */
        public static final String VALIDATION_FAILED = "Validation failed";
        public static final String REQUIRED_FIELDS_MISSING = "Required fields are missing";



    private ResponseUtils() {}

    public static <T> ResponseEntity<ApiResponse<T>> success(String message,T data) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                        .success(true)
                        .message(message)
                        .data(data)
                        .status(HttpStatus.OK.value())
                        .timestamp(LocalDateTime.now())
                        .build();
        return ResponseEntity.ok(response);
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(String message,T data,HttpStatus status) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                        .success(true)
                        .message(message)
                        .data(data)
                        .status(status.value())
                        .timestamp(LocalDateTime.now())
                        .build();
        return new ResponseEntity<>(response, status);
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(String message,T data) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                        .success(true)
                        .message(message)
                        .data(data)
                        .status(HttpStatus.CREATED.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(String message) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                        .success(false)
                        .message(message)
                        .status(HttpStatus.BAD_REQUEST.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(String message,HttpStatus status) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                        .success(false)
                        .message(message)
                        .status(status.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(response,status);
    }

    public static <T> ResponseEntity<ApiResponse<T>> unauthorized(String message) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                        .success(false)
                        .message(message)
                        .status(HttpStatus.UNAUTHORIZED.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(response,HttpStatus.UNAUTHORIZED);
    }

    public static <T> ResponseEntity<ApiResponse<T>> forbidden(String message) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                        .success(false)
                        .message(message)
                        .status(HttpStatus.FORBIDDEN.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(response,HttpStatus.FORBIDDEN);
    }

    public static <T> ResponseEntity<ApiResponse<T>> notFound(String message) {

        ApiResponse<T> response = ApiResponse.<T>builder()
                        .success(false)
                        .message(message)
                        .status(HttpStatus.NOT_FOUND.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    public static <T> ResponseEntity<ApiResponse<T>> validationError(String message) {

        ApiResponse<T> response = ApiResponse.<T>builder()
                        .success(false)
                        .message(message)
                        .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(response,HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public static <T> ResponseEntity<ApiResponse<T>> internalServerError(String message) {

        ApiResponse<T> response = ApiResponse.<T>builder()
                        .success(false)
                        .message(message)
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .timestamp(LocalDateTime.now())
                        .build();

        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}