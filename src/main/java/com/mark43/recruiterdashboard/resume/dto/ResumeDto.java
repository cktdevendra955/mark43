package com.mark43.recruiterdashboard.resume.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ResumeDto {

    private UUID uniqueId;

    private UUID userProfileId;

    private String resumeUrl;

    private String parsedSkills;

    private String parsedExperience;

    private Double atsScore;

    private Boolean active;
}
