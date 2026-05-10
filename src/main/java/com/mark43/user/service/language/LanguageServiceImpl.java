package com.mark43.user.service.language;

import com.mark43.user.dto.LanguageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LanguageServiceImpl implements LanguageService{

    @Override
    public ResponseEntity<?> create(LanguageDto dto) {
        return null;
    }

    @Override
    public Map<String, Object> getAll() {
        return Map.of();
    }

    @Override
    public Map<String, Object> getById(String id) {
        return Map.of();
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }
}
