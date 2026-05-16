package com.mark43.user.dto.language;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLanguageResponseDto {
    private Long profileId;
    private Long languageId;
    private String proficiencyLevel;
}
