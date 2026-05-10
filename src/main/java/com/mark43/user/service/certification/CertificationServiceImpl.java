package com.mark43.user.service.certification;

import com.mark43.user.dto.CertificationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CertificationServiceImpl implements CertificationService{


    @Override
    public ResponseEntity<?> save(CertificationDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(String uniqueId, CertificationDto dto) {
        return null;
    }

    @Override
    public Map<String, Object> getByProfileId(String profileId) {
        return Map.of();
    }

    @Override
    public ResponseEntity<?> delete(String uniqueId) {
        return null;
    }
}
