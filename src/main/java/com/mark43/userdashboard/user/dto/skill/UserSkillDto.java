package com.mark43.userdashboard.user.dto.skill;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSkillDto {
    private Long profileId;
    private Long skillId;
    private Integer experienceYears;
    private String proficiencyLevel;
}
