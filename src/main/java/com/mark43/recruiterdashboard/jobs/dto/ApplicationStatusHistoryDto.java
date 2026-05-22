package com.mark43.recruiterdashboard.jobs.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ApplicationStatusHistoryDto {

    private UUID uniqueId;

    private UUID applicationId;

    private String oldStatus;

    private String newStatus;

    private String remarks;
}