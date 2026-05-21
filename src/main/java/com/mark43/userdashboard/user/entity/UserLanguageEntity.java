package com.mark43.userdashboard.user.entity;


import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "job_seeker_languages")
@Getter
@Setter
public class UserLanguageEntity extends BaseEntity {
    private Long profileId;
    private Long languageId;
    private String proficiencyLevel;
}
