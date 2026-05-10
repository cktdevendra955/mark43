package com.mark43.user.service.experience;

import com.mark43.user.dto.ExperienceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExperienceServiceImpl implements ExperienceService{


    @Override
    public ResponseEntity<?> create(ExperienceDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(String id, ExperienceDto dto) {
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
