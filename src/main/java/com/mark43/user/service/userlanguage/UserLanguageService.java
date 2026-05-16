package com.mark43.user.service.userlanguage;

import com.mark43.user.dto.language.UserLanguageDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface UserLanguageService {

    ResponseEntity<?> create(UserLanguageDto dto);
    ResponseEntity<?> getAllByUser();
    ResponseEntity<?> delete(UUID uniqueId);
}