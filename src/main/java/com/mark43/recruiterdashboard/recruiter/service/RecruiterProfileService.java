package com.mark43.recruiterdashboard.recruiter.service;

import com.mark43.recruiterdashboard.recruiter.dto.RecruiterProfileDto;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.UUID;

public interface RecruiterProfileService {
    ResponseEntity<?> create(RecruiterProfileDto dto);
    ResponseEntity<?> update(UUID uniqueId,RecruiterProfileDto dto);
    ResponseEntity<?> getAll(Map<String, Object> params);
    ResponseEntity<?> getByUniqueId(UUID uniqueId);
    ResponseEntity<?> delete(UUID uniqueId);
}