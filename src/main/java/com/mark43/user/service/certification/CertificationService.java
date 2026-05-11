package com.mark43.user.service.certification;


import com.mark43.user.dto.CertificationDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface CertificationService {
    ResponseEntity<?> create(CertificationDto dto);
    ResponseEntity<?> update(UUID uniqueId, CertificationDto dto);
    ResponseEntity<?> getAllByUser();
    ResponseEntity<?> delete(UUID uniqueId);
}