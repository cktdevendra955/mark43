package com.mark43.recruiterdashboard.jobs.service;

import com.mark43.recruiterdashboard.jobs.dto.ApplicationStatusHistoryDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface ApplicationStatusHistoryService {
    ResponseEntity<?> create(ApplicationStatusHistoryDto dto);
    ResponseEntity<?> update(UUID uniqueId,ApplicationStatusHistoryDto dto);
    ResponseEntity<?> getAll(Map<String, Object> params);
    ResponseEntity<?> getByUniqueId(UUID uniqueId);
    ResponseEntity<?> delete(UUID uniqueId);
}
