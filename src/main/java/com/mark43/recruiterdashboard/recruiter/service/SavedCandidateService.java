package com.mark43.recruiterdashboard.recruiter.service;

import com.mark43.recruiterdashboard.recruiter.dto.SavedCandidateDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface SavedCandidateService {
    ResponseEntity<?> create(SavedCandidateDto dto);
    ResponseEntity<?> update(UUID uniqueId,SavedCandidateDto dto);
    ResponseEntity<?> getAll(Map<String, Object> params);
    ResponseEntity<?> getByUniqueId(UUID uniqueId);
    ResponseEntity<?> delete(UUID uniqueId);
}