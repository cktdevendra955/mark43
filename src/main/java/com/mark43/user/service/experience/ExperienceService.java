package com.mark43.user.service.experience;

import com.mark43.user.dto.ExperienceDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ExperienceService {

    ResponseEntity<?> create(ExperienceDto dto);

    ResponseEntity<?> update(String id, ExperienceDto dto);

    Map<String,Object> getByProfileId(String profileId);

    ResponseEntity<?> delete(Long id);
}
