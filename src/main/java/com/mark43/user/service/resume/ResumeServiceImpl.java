package com.mark43.user.service.resume;

import com.mark43.user.dto.ResumeDto;
import com.mark43.user.dto.language.UserLanguageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class ResumeServiceImpl implements ResumeService{


    @Override
    public ResponseEntity<?> upload(UserLanguageDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<?> getResumeByUser() {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {
        return null;
    }
}
