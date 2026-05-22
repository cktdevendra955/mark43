package com.mark43.common.job.entity;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "reported_jobs")
public class ReportedJobEntity extends BaseEntity {
    private Long jobId;
    private Long reportedBy;
    private String reason;
}