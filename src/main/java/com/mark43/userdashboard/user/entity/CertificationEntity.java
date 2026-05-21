package com.mark43.userdashboard.user.entity;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "certifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CertificationEntity extends BaseEntity {

//    @ManyToOne
//    @JoinColumn(name = "profile_id")
    private Long profile;

    private String name;

    private String organization;

    private LocalDate issueDate;

    private LocalDate expiryDate;

    private String credentialId;

    private String certificateUrl;
}