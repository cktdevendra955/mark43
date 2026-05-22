package com.mark43.recruiterdashboard.interview.entity;


import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "interviews")
@Getter
@Setter
public class InterviewEntity extends BaseEntity {
    private Long jobApplicationId;
    private String interviewRound;
    private String interviewerName;
    private String interviewType;
    private LocalDateTime interviewDateTime;
    private String meetingLink;
    private String feedback;
    private String result;
    private Boolean completed = false;
}
