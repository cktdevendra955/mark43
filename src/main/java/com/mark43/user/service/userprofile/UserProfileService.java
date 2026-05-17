package com.mark43.user.service.userprofile;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserProfileService {
    ResponseEntity<?> createOrUpdate(Map<String,Object> dto);
    Map<String,Object> getByUserId(Long userId);
    ResponseEntity<?> delete(Long id);
}
