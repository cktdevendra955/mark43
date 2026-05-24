package com.mark43.recruiterdashboard.interview.service;

import com.mark43.recruiterdashboard.interview.dto.InterviewFeedbackDto;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.UUID;

public interface InterviewFeedbackService {
    ResponseEntity<?> create(InterviewFeedbackDto dto);
    ResponseEntity<?> update(UUID uniqueId,InterviewFeedbackDto dto);
    ResponseEntity<?> getAll(Map<String, Object> params);
    ResponseEntity<?> getByUniqueId(UUID uniqueId);
    ResponseEntity<?> delete(UUID uniqueId);


}
