package com.mark43.user.service.education;

import com.mark43.user.dto.EducationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EducationServiceImpl implements EducationService{


    @Override
    public ResponseEntity<?> create(EducationDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(String UniqueId, EducationDto dto) {
        return null;
    }

    @Override
    public Map<String, Object> getByProfileId(String profileId) {
        return Map.of();
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }
}
