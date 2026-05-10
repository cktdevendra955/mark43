package com.mark43.user.service.education;

import com.mark43.user.dto.EducationDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface EducationService {
    ResponseEntity<?> create(EducationDto dto);
    ResponseEntity<?> update(String UniqueId, EducationDto dto);
    Map<String,Object> getByProfileId(String profileId);
    ResponseEntity<?>  delete(Long id);
}