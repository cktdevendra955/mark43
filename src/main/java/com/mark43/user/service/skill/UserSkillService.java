package com.mark43.user.service.skill;

import com.mark43.user.dto.skill.UserSkillDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface UserSkillService {
    ResponseEntity<?> create(UserSkillDto dto);
    ResponseEntity<?> getAllByUser();
    ResponseEntity<?> delete(UUID uniqueId);
}