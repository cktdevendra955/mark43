package com.mark43.user.service.language;

import com.mark43.user.dto.UserLanguageDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserLanguageService {

    ResponseEntity<?> create(UserLanguageDto dto);

    Map<String,Object> getByProfileId(String profileId);

    ResponseEntity<?> delete(Long id);
}