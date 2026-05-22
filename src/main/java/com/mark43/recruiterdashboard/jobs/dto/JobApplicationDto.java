package com.mark43.recruiterdashboard.jobs.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class JobApplicationDto {

    private UUID uniqueId;

    private UUID jobId;

    private UUID candidateId;

    private String resumeUrl;

    private String coverLetter;

    private String status;

    private String appliedVia;

    private Boolean viewed;

    private Boolean shortlisted;

    private Boolean rejected;
}