package com.mark43.user.service.language;

import com.mark43.user.dto.language.UserLanguageDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface UserLanguageService {

    ResponseEntity<?> create(UserLanguageDto dto);

    ResponseEntity<?> getAllByUser();

    ResponseEntity<?> delete(UUID uniqueId);
}