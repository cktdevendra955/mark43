package com.mark43.userdashboard.user.dto.experience;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ExperienceDto {
    private String companyName;

    private String designation;

    private String responsibilities;

    private String employmentType;

    private String location;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean currentlyWorking;
}
