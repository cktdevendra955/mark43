package com.mark43.recruiterdashboard.recruiter.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RecruiterProfileDto {
    private UUID uniqueId;
    private UUID userProfileId;
    private UUID companyId;
    private String designation;
    private String department;
    private String recruiterType;
    private Boolean verified;
    private Boolean active;
}