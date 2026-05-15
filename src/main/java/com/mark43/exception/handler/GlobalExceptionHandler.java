package com.mark43.exception.handler;

import com.mark43.utils.response.ApiResponse;
import com.mark43.utils.response.ResponseUtils;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /*
     * Validation Exception
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception
    ) {

        log.error("Validation Exception : ", exception);

        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error -> {

                    String fieldName = error.getField();
                    String message = error.getDefaultMessage();

                    errors.put(fieldName, message);
                });

        return ResponseUtils.validationError(
                "Validation failed"
        );
    }

    /*
     * Constraint Violation Exception
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<String>> handleConstraintViolationException(
            ConstraintViolationException exception
    ) {

        log.error("Constraint Violation Exception : ", exception);

        return ResponseUtils.error(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }

    /*
     * Missing Request Parameter
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiResponse<String>> handleMissingServletRequestParameterException(
            MissingServletRequestParameterException exception
    ) {

        log.error("Missing Request Parameter Exception : ", exception);

        return ResponseUtils.error(
                exception.getParameterName() + " parameter is missing",
                HttpStatus.BAD_REQUEST
        );
    }

    /*
     * Invalid JSON Request Body
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse<String>> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException exception
    ) {

        log.error("Http Message Not Readable Exception : ", exception);

        return ResponseUtils.error(
                "Invalid request body",
                HttpStatus.BAD_REQUEST
        );
    }

    /*
     * Invalid Path Variable / Request Param Type
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse<String>> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exception
    ) {

        log.error("Method Argument Type Mismatch Exception : ", exception);

        return ResponseUtils.error(
                "Invalid parameter value : " + exception.getName(),
                HttpStatus.BAD_REQUEST
        );
    }

    /*
     * Unsupported HTTP Method
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiResponse<String>> handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException exception
    ) {

        log.error("Http Request Method Not Supported Exception : ", exception);

        return ResponseUtils.error(
                "HTTP method not supported",
                HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    /*
     * Unsupported Media Type
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ApiResponse<String>> handleHttpMediaTypeNotSupportedException(
            HttpMediaTypeNotSupportedException exception
    ) {

        log.error("Http Media Type Not Supported Exception : ", exception);

        return ResponseUtils.error(
                "Media type not supported",
                HttpStatus.UNSUPPORTED_MEDIA_TYPE
        );
    }

    /*
     * Entity Not Found
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleEntityNotFoundException(
            EntityNotFoundException exception
    ) {

        log.error("Entity Not Found Exception : ", exception);

        return ResponseUtils.notFound(
                exception.getMessage()
        );
    }

    /*
     * Duplicate Key Exception
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ApiResponse<String>> handleDuplicateKeyException(
            DuplicateKeyException exception
    ) {

        log.error("Duplicate Key Exception : ", exception);

        return ResponseUtils.error(
                "Duplicate data found",
                HttpStatus.CONFLICT
        );
    }

    /*
     * Database Constraint Exception
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse<String>> handleDataIntegrityViolationException(
            DataIntegrityViolationException exception
    ) {

        log.error("Data Integrity Violation Exception : ", exception);

        return ResponseUtils.error(
                "Database constraint violation",
                HttpStatus.CONFLICT
        );
    }

    /*
     * Illegal Argument Exception
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<String>> handleIllegalArgumentException(
            IllegalArgumentException exception
    ) {

        log.error("Illegal Argument Exception : ", exception);

        return ResponseUtils.error(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }

    /*
     * Authentication Exception
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiResponse<String>> handleBadCredentialsException(
            BadCredentialsException exception
    ) {

        log.error("Bad Credentials Exception : ", exception);

        return ResponseUtils.unauthorized(
                "Invalid credentials"
        );
    }

    /*
     * Access Denied Exception
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse<String>> handleAccessDeniedException(
            AccessDeniedException exception
    ) {

        log.error("Access Denied Exception : ", exception);

        return ResponseUtils.forbidden("");
    }

    /*
     * Null Pointer Exception
     */
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiResponse<String>> handleNullPointerException(
            NullPointerException exception
    ) {

        log.error("Null Pointer Exception : ", exception);

        return ResponseUtils.internalServerError(
                "Null value encountered"
        );
    }

    /*
     * Runtime Exception
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<String>> handleRuntimeException(
            RuntimeException exception
    ) {

        log.error("Runtime Exception : ", exception);

        return ResponseUtils.internalServerError(
                "Runtime exception occurred"
        );
    }

    /*
     * Global Exception
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(
            Exception exception
    ) {

        log.error("Global Exception : ", exception);

        return ResponseUtils.internalServerError(
                "Something went wrong"
        );
    }
}