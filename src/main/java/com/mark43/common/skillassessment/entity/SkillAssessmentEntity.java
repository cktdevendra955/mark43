package com.mark43.common.skillassessment.entity;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "skill_assessments")
public class SkillAssessmentEntity extends BaseEntity {

    private String title;

    private String description;

    private Integer durationMinutes;

    private Integer totalMarks;

    private Boolean active = true;
}
