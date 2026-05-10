package com.mark43.user.service.language;

import com.mark43.user.dto.UserLanguageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserLanguageServiceImp implements UserLanguageService{


    @Override
    public ResponseEntity<?> create(UserLanguageDto dto) {
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
