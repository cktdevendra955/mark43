package com.mark43.user.service.resume;

import com.mark43.user.dto.ResumeDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ResumeService {

    ResponseEntity<?> create(ResumeDto entity);

    Map<String,Object> getByProfileId(String profileId);

    Map<String,Object> getPrimaryResume(String profileId);

    ResponseEntity<?> delete(String id);
}