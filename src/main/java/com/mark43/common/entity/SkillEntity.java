package com.mark43.common.entity;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "job_seeker_skills")
@Getter
@Setter
public class SkillEntity extends BaseEntity {
    private Long profileId;
    private Long skillId;
    private Integer experienceYears;
    private String proficiencyLevel;
}