package com.mark43.recruiterdashboard.interview.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class InterviewDto {

    private UUID uniqueId;

    private UUID applicationId;

    private String interviewRound;

    private String interviewerName;

    private String interviewType;

    private LocalDateTime interviewDateTime;

    private String meetingLink;

    private String feedback;

    private String result;

    private Boolean completed;
}
