package com.mark43.recruiterdashboard.interview.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class InterviewFeedbackDto {

    private UUID uniqueId;
    private UUID interviewId;
    private String technicalFeedback;
    private String hrFeedback;
    private Integer rating;
    private String recommendation;
}
