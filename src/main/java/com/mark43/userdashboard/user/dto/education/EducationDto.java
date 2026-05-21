package com.mark43.userdashboard.user.dto.education;
import com.mark43.userdashboard.user.entity.UserProfileEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EducationDto {
    private UserProfileEntity profile;

    private String instituteName;

    private String degree;

    private String fieldOfStudy;

    private Double percentage;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean currentlyPursuing;
}
