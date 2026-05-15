package com.mark43.user.dto.education;


import lombok.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationResponseDto {

    private UUID uniqueId;
    private String instituteName;
    private String degree;
    private String fieldOfStudy;
    private Double percentage;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean currentlyPursuing;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

}