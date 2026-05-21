package com.mark43.userdashboard.user.service.userprofile;

import com.mark43.userdashboard.user.dto.userprofile.UserProfileDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface UserProfileService {
    ResponseEntity<?> create(UserProfileDto dto);
    ResponseEntity<?> update(UUID uniqueId, UserProfileDto dto);
    ResponseEntity<?> delete(UUID uniqueId);
}
