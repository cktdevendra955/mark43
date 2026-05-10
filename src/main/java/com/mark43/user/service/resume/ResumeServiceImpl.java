package com.mark43.user.service.resume;

import com.mark43.user.dto.ResumeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ResumeServiceImpl implements ResumeService{


    @Override
    public ResponseEntity<?> create(ResumeDto entity) {
        return null;
    }

    @Override
    public Map<String, Object> getByProfileId(String profileId) {
        return Map.of();
    }

    @Override
    public Map<String, Object> getPrimaryResume(String profileId) {
        return Map.of();
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        return null;
    }
}
