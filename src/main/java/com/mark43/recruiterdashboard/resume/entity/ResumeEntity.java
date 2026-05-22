package com.mark43.recruiterdashboard.resume.entity;


import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "resumes")
@Getter
@Setter
public class ResumeEntity extends BaseEntity {
    private Long userProfileId;
    private String resumeUrl;
    private String parsedSkills;
    private String parsedExperience;
    private Double atsScore;
    private Boolean active = true;
}