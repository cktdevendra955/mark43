package com.mark43.userdashboard.jobs.entity;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "saved_jobs")
public class SavedJobEntity extends BaseEntity {
    private Long userProfileId;
    private Long jobId;
}
