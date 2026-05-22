package com.mark43.recruiterdashboard.jobs.service;

import com.mark43.recruiterdashboard.jobs.dto.JobApplicationDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface JobApplicationService {

    ResponseEntity<?> create(JobApplicationDto dto);
    ResponseEntity<?> update(UUID uniqueId,JobApplicationDto dto);
    ResponseEntity<?> getAll(Map<String, Object> params);
    ResponseEntity<?> getByUniqueId(UUID uniqueId);
    ResponseEntity<?> delete(UUID uniqueId);
    ResponseEntity<?> changeStatus(UUID uniqueId,String status);
}
