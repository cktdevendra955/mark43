package com.mark43.basefiles;
import java.time.LocalDateTime;
import java.util.UUID;

public class BaseDto {
    private Long id;
    private UUID uniqueId;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
    private LocalDateTime deletedAt;
    private Long deletedBy;
    private Boolean isDeleted = false;
}
