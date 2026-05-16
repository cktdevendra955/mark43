package com.mark43.user.service.skill;

import com.mark43.user.dto.skill.SkillDto;
import com.mark43.user.entity.SkillEntity;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface SkillService {
    ResponseEntity<?> create(SkillDto dto);
    ResponseEntity<?> getAllByUser();
    ResponseEntity<?> delete(UUID uniqueId);
}