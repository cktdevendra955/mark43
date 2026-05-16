package com.mark43.user.service.language;

import com.mark43.user.dto.ExperienceDto;
import com.mark43.user.dto.LanguageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class LanguageServiceImpl implements LanguageService{

    @Override
    public ResponseEntity<?> create(ExperienceDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(UUID uniqueId, ExperienceDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAllByUser() {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {
        return null;
    }
}
