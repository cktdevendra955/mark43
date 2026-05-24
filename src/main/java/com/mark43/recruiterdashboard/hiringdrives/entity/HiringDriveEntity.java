package com.mark43.recruiterdashboard.hiringdrives.entity;

import com.mark43.basefiles.BaseEntity;
import com.mark43.common.entity.skill.SkillEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "hiring_drives")
@Getter
@Setter
public class HiringDriveEntity extends BaseEntity {
    private String title;
    private String companyName;
    private String description;
    private String hiringType;
    private String jobRole;
    private String experience;
    private String packageOffered;
    private String location;
    @ManyToMany
    @JoinTable(name = "hiring_drive_skills",joinColumns = @JoinColumn(name = "hiring_drive_id"),inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<SkillEntity> skillsRequired;
    private String eligibilityCriteria;
    private LocalDate lastApplyDate;
    private LocalDate driveDate;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Integer totalOpenings;
    private String companyWebsite;
    private String registrationUrl;
    @Column(length = 5000)
    private String venueAddress;
    private String contactEmail;
    private String contactPhone;
    private String bannerImage;
    private String status;
    private Boolean featured = false;
    private Long totalApplicants = 0L;
}