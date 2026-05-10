package com.mark43.user.service.certification;


import com.mark43.user.dto.CertificationDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface CertificationService {
    ResponseEntity<?>  save(CertificationDto dto);
    ResponseEntity<?> update(String uniqueId, CertificationDto dto);
    Map<String,Object> getByProfileId(String profileId);
    ResponseEntity<?> delete(String uniqueId);
}