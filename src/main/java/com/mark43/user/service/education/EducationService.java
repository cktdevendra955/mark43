package com.mark43.user.service.education;

import com.mark43.user.dto.CertificationDto;
import com.mark43.user.dto.EducationDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface EducationService {
    ResponseEntity<?> create(EducationDto dto);
    ResponseEntity<?> update(UUID uniqueId, EducationDto dto);
    ResponseEntity<?> getAllByUser();
    ResponseEntity<?> delete(UUID uniqueId);
}