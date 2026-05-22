package com.mark43.recruiterdashboard.recruiter.entity;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "recruiter_profiles")
@Getter
@Setter
public class RecruiterProfileEntity extends BaseEntity {
    private Long userProfileId;
    private Long companyId;
    private String designation;
    private String department;
    private String recruiterType;
    private Boolean verified = false;
    private Boolean active = true;
}