package com.mark43.user.service.experience;

import com.mark43.user.dto.ExperienceDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ExperienceService {

    ResponseEntity<?> create(ExperienceDto dto);
    ResponseEntity<?> update(UUID uniqueId, ExperienceDto dto);
    ResponseEntity<?> getAllByUser();
    ResponseEntity<?> delete(UUID uniqueId);
}
