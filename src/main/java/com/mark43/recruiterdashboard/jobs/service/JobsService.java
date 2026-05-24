package com.mark43.recruiterdashboard.jobs.service;


import com.mark43.recruiterdashboard.jobs.dto.ApplicationStatusHistoryDto;
import com.mark43.recruiterdashboard.jobs.dto.JobApplicationDto;
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


    //** JOB APPLICATION **/
    ResponseEntity<?> jobApplicationCreate(JobApplicationDto dto);
    ResponseEntity<?> jobApplicationUpdate(UUID uniqueId,JobApplicationDto dto);
    ResponseEntity<?> jobApplicationGetAll(Map<String, Object> params);
    ResponseEntity<?> jobApplicationGetByUniqueId(UUID uniqueId);
    ResponseEntity<?> jobApplicationDelete(UUID uniqueId);
    ResponseEntity<?> jobApplicationChangeStatus(UUID uniqueId, String status);


    //** JOB APPLICATION HISTORY **/
    ResponseEntity<?> applicationStatusHistoryCreate(ApplicationStatusHistoryDto dto);
    ResponseEntity<?> applicationStatusHistoryUpdate(UUID uniqueId,ApplicationStatusHistoryDto dto);
    ResponseEntity<?> applicationStatusHistoryGetAll(Map<String, Object> params);
    ResponseEntity<?> applicationStatusHistoryGetByUniqueId(UUID uniqueId);
    ResponseEntity<?> applicationStatusHistoryDelete(UUID uniqueId);

}