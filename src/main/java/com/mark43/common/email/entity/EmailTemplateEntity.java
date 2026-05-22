package com.mark43.common.email.entity;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "email_templates")
public class EmailTemplateEntity extends BaseEntity {
    private String name;
    private String subject;
    private String body;
    private Boolean active = true;
}
