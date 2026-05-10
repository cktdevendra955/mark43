package com.mark43.user.service.language;

import com.mark43.user.dto.LanguageDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface LanguageService {

    ResponseEntity<?> create(LanguageDto dto);

    Map<String,Object> getAll();

    Map<String,Object> getById(String id);

    ResponseEntity<?> delete(Long id);
}
