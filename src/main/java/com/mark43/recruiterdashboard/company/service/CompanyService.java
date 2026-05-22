package com.mark43.recruiterdashboard.company.service;


import com.mark43.recruiterdashboard.company.dto.CompanyDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface CompanyService {
    ResponseEntity<?> create(CompanyDto dto);
    ResponseEntity<?> update(UUID uniqueId,CompanyDto dto);
    ResponseEntity<?> getAll(Map<String, Object> params);
    ResponseEntity<?> getByUniqueId(UUID uniqueId);
    ResponseEntity<?> delete(UUID uniqueId);
}
