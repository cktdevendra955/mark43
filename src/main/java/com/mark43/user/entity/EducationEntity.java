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
@Table(name = "educations")
@Getter
@Setter
public class EducationEntity extends BaseEntity {

    private Long profile;

    private String instituteName;

    private String degree;

    private String fieldOfStudy;

    private Double percentage;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean currentlyPursuing;
}
