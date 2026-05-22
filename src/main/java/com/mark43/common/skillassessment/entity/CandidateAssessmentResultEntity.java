package com.mark43.common.skillassessment.entity;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidate_assessment_results")
public class CandidateAssessmentResultEntity extends BaseEntity {
    private Long userProfileId;
    private Long assessmentId;
    private Integer score;
    private Boolean passed;
}
