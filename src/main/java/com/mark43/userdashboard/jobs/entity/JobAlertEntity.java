package com.mark43.userdashboard.jobs.entity;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_alerts")
public class JobAlertEntity extends BaseEntity {
    private Long userProfileId;
    private String keyword;
    private String location;
    private String experience;
    private Boolean active = true;
}