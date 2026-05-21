package com.mark43.userdashboard.user.entity;


import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "experiences")
@Getter
@Setter
public class ExperienceEntity extends BaseEntity {

    private Long profile;

    private String companyName;

    private String designation;

    @Column(length = 5000)
    private String responsibilities;

    private String employmentType;

    private String location;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean currentlyWorking;
}