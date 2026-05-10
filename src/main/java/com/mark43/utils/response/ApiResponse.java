package com.mark43.utils.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    /**
     * Response status
     */
    private boolean success;

    /**
     * Response message
     */
    private String message;

    /**
     * HTTP status code
     */
    private Integer status;

    /**
     * Response data
     */
    private T data;

    /**
     * Error details
     */
    private Object errors;

    /**
     * API timestamp
     */
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    /**
     * Request path
     */
    private String path;

    /**
     * Request unique id
     */
    private String requestId;
}
