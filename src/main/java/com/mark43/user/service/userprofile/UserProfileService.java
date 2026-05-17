package com.mark43.user.service.userprofile;

import com.mark43.user.dto.project.ProjectDto;
import com.mark43.user.dto.userprofile.UserProfileDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface UserProfileService {
    ResponseEntity<?> create(UserProfileDto dto);
    ResponseEntity<?> update(UUID uniqueId, UserProfileDto dto);
    ResponseEntity<?> delete(UUID uniqueId);
}
