package com.mark43.userdashboard.jobs.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface JobService {
    ResponseEntity<?> getAllOrderBy(Map<String,Object> params);
    ResponseEntity<?> getByUniqueId(UUID uniqueId);
}
