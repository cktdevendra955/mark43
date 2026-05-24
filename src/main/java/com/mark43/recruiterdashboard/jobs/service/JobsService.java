package com.mark43.recruiterdashboard.jobs.service;


import com.mark43.recruiterdashboard.jobs.dto.JobsDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface JobsService {

    ResponseEntity<?> create(JobsDto dto);
    ResponseEntity<?> update(UUID uniqueId,JobsDto dto);
    ResponseEntity<?> getAll(Map<String, Object> params);
    ResponseEntity<?> getByUniqueId(UUID uniqueId);
    ResponseEntity<?> delete(UUID uniqueId);
    ResponseEntity<?> changeStatus(UUID uniqueId,String status);
    ResponseEntity<?> getFeatured();
    ResponseEntity<?> getUrgentHiring();
    ResponseEntity<?> getActiveJobs();
    ResponseEntity<?> search(String keyword);
}