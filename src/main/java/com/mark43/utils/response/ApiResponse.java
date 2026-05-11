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

    private boolean success;
    private String message;
    private Integer status;
    private T data;
    private Object errors;
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
    private String path;
    private String requestId;
}
