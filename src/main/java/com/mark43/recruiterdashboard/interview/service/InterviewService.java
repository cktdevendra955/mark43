package com.mark43.recruiterdashboard.interview.service;


import com.mark43.recruiterdashboard.interview.dto.InterviewDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface InterviewService {

    ResponseEntity<?> create(InterviewDto dto);
    ResponseEntity<?> update(UUID uniqueId,InterviewDto dto);
    ResponseEntity<?> getAll(Map<String, Object> params);
    ResponseEntity<?> getByUniqueId(UUID uniqueId);
    ResponseEntity<?> delete(UUID uniqueId);
}