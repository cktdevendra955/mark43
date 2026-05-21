package com.mark43.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class HiringDriveDto {

    private String title;
    private String companyName;
    private String description;
    private String hiringType;
    private String jobRole;
    private String experience;
    private String packageOffered;
    private String location;
    private List<UUID> skillIds;

    private String eligibilityCriteria;
    private LocalDate lastApplyDate;
    private LocalDate driveDate;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Integer totalOpenings;
    private String companyWebsite;
    private String registrationUrl;
    private String venueAddress;
    private String contactEmail;
    private String contactPhone;
    private String bannerImage;
    private String status;
    private Boolean featured;
    private Long totalApplicants;
}

