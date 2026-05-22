package com.mark43.recruiterdashboard.recruiter.entity;


import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "saved_candidates")
@Getter
@Setter
public class SavedCandidateEntity extends BaseEntity {
    private Long recruiterId;
    private Long userProfileId;
    private String notes;
}