package com.mark43.recruiterdashboard.interview.entity;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "interview_feedbacks")
@Getter
@Setter
public class InterviewFeedbackEntity extends BaseEntity {
    private Long interviewId;

    @Column(length = 5000)
    private String technicalFeedback;

    @Column(length = 5000)
    private String hrFeedback;

    private Integer rating;

    private String recommendation;
}
