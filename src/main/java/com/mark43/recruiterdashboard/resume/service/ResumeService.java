package com.mark43.recruiterdashboard.resume.service;

import com.mark43.recruiterdashboard.resume.dto.ResumeDto;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.UUID;

public interface ResumeService {
    ResponseEntity<?> create(ResumeDto dto);
    ResponseEntity<?> update(UUID uniqueId,ResumeDto dto);
    ResponseEntity<?> getAll(Map<String, Object> params);
    ResponseEntity<?> getByUniqueId(UUID uniqueId);
    ResponseEntity<?> delete(UUID uniqueId);
}