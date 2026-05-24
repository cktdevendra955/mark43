package com.mark43.recruiterdashboard.hiringdrives.service;

import com.mark43.recruiterdashboard.hiringdrives.dto.HiringDriveDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface HiringDriveService {
    ResponseEntity<?> create(HiringDriveDto dto);
    ResponseEntity<?> update(UUID uniqueId,HiringDriveDto dto);
    ResponseEntity<?> getAll(Map<String, Object> params);
    ResponseEntity<?> getByUniqueId(UUID uniqueId);
    ResponseEntity<?> delete(UUID uniqueId);
    ResponseEntity<?> changeStatus(UUID uniqueId,String status);
    ResponseEntity<?> getFeatured();
    ResponseEntity<?> search(String keyword);
}