package com.mark43.userdashboard.drives.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface DrivesService {

    ResponseEntity<?> getAllOrderBy(Map<String,Object> params);
    ResponseEntity<?> getByUniqueId(UUID uniqueId);
}
