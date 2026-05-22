package com.mark43.common.activitylogs.entity;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "activity_logs")
public class ActivityLogEntity extends BaseEntity {
    private Long userId;
    private String action;
    private String moduleName;
    private String ipAddress;
    private String deviceInfo;
}