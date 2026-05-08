package com.mark43.user.entity;


import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "projects")
@Getter
@Setter
public class ProjectEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private UserProfileEntity profile;

    private String title;

    @Column(length = 5000)
    private String description;

    private String technologiesUsed;

    private String projectUrl;

    private String githubUrl;

    private LocalDate startDate;

    private LocalDate endDate;
}