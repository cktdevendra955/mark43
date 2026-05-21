package com.mark43.userdashboard.user.dto.userprofile;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserProfileResponseDto {

    private Long userId;
    private String headline;

    private String summary;

    private Integer totalExperience;

    private String currentCompany;

    private String currentDesignation;

    private String highestEducation;

    private String expectedSalary;

    private String currentSalary;

    private String noticePeriod;

    private String profilePhoto;

    private LocalDate dateOfBirth;

    private String gender;

    private String maritalStatus;

    private String city;

    private String state;

    private String country;

    private String pincode;

    private Boolean openToWork = true;

    private Boolean profileCompleted = false;
}
