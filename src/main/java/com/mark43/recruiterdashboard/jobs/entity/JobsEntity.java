
package com.mark43.recruiterdashboard.jobs.entity;

import com.mark43.basefiles.BaseEntity;
import com.mark43.common.entity.skill.SkillEntity;

import com.mark43.userdashboard.user.entity.UserProfileEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "jobs")
@Getter
@Setter
public class JobsEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private UserProfileEntity recruiter;

    private String title;

    @Column(length = 5000)
    private String description;

    private String companyName;

    private String jobType;

    private String workMode;

    private String experience;

    private String salary;

    private String location;

    private String openings;

    private String qualification;

    @Column(length = 3000)
    private String responsibilities;

    @Column(length = 3000)
    private String requirements;

    @ManyToMany
    @JoinTable(
            name = "job_skills",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<SkillEntity> skills;

    private LocalDate lastApplyDate;

    private String companyWebsite;

    private String companyLogo;

    private String applicationUrl;

    private Boolean featured = false;

    private Boolean urgentHiring = false;

    private Boolean active = true;

    private Long totalApplications = 0L;

    private String status;
}

