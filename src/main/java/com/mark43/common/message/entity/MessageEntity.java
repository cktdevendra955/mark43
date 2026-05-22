package com.mark43.common.message.entity;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages")
public class MessageEntity extends BaseEntity {
    private Long sender;
    private Long receiver;
    private String message;
    private Boolean seen = false;
}