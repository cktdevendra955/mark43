package com.mark43.user.service.resume;

import com.mark43.user.dto.ResumeDto;
import com.mark43.user.dto.language.UserLanguageDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface ResumeService {

    ResponseEntity<?> upload(UserLanguageDto dto);
    ResponseEntity<?> getResumeByUser();
    ResponseEntity<?> delete(UUID uniqueId);
}