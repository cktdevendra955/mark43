package com.mark43.recruiterdashboard.recruiter.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SavedCandidateDto {

    private UUID uniqueId;

    private UUID recruiterId;

    private UUID candidateId;

    private String notes;
}