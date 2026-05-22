package com.mark43.recruiterdashboard.jobs.entity;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "application_status_history")
@Getter
@Setter
public class ApplicationStatusHistoryEntity extends BaseEntity {
    private Long jobApplicationId;
    private String oldStatus;
    private String newStatus;
    private String remarks;
}