package com.mark43.common.job.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class JobsDto {

    private UUID uniqueId;

    private Long recruiterId;

    private String title;

    private String description;

    private String companyName;

    private String jobType;

    private String workMode;

    private String experience;

    private String salary;

    private String location;

    private String openings;

    private String qualification;

    private String responsibilities;

    private String requirements;

    private List<UUID> skillIds;

    private LocalDate lastApplyDate;

    private String companyWebsite;

    private String companyLogo;

    private String applicationUrl;

    private Boolean featured;

    private Boolean urgentHiring;

    private Boolean active;

    private Long totalApplications;

    private String status;
}