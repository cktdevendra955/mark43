package com.mark43.user.dto.resume;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResumeDto {
    private Long profileId;
    private String resumeName;
    private String resumeUrl;
    private Boolean primaryResume = false;
}
