package com.mark43.userdashboard.user.service.certification;


import com.mark43.userdashboard.user.dto.certification.CertificationDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CertificationService {
    ResponseEntity<?> create(CertificationDto dto);
    ResponseEntity<?> update(UUID uniqueId, CertificationDto dto);
    ResponseEntity<?> getAllByUser();
    ResponseEntity<?> delete(UUID uniqueId);
}