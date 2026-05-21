package com.mark43.userdashboard.user.dto.project;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProjectResponseDto {
    private Long profile;
    private String title;
    private String description;
    private String technologiesUsed;
    private String projectUrl;
    private String githubUrl;
    private LocalDate startDate;
    private LocalDate endDate;
}
