package com.mark43.user.service.language;

import com.mark43.user.dto.ExperienceDto;
import com.mark43.user.dto.LanguageDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface LanguageService {
    ResponseEntity<?> create(ExperienceDto dto);
    ResponseEntity<?> update(UUID uniqueId, ExperienceDto dto);
    ResponseEntity<?> getAllByUser();
    ResponseEntity<?> delete(UUID uniqueId);
}
