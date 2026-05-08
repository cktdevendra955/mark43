package com.mark43.user.entity;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "certifications")
@Getter
@Setter
public class CertificationEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private UserProfileEntity profile;

    private String name;

    private String organization;

    private LocalDate issueDate;

    private LocalDate expiryDate;

    private String credentialId;

    private String certificateUrl;
}