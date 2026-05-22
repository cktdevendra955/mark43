package com.mark43.recruiterdashboard.jobs.entity;


import com.mark43.basefiles.BaseEntity;
import com.mark43.common.entity.jobs.JobsEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "job_applications")
@Getter
@Setter
public class JobApplicationEntity extends BaseEntity {
    private Long jobId;
    private Long candidateId;
    private String resumeUrl;
    private String coverLetter;
    private String status;
    private String appliedVia;
    private Boolean viewed = false;
    private Boolean shortlisted = false;
    private Boolean rejected = false;
}