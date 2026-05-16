package com.mark43.user.dto.language;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLanguageDto {
    private Long profileId;
    private Long languageId;
    private String proficiencyLevel;
}
