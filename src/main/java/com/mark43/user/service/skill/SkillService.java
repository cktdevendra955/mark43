package com.mark43.user.service.skill;

import com.mark43.user.dto.SkillResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface SkillService {

    ResponseEntity<?> createSkill(SkillResponseDto dto);

    Map<String,Object> getAllSkills();

    Map<String,Object> getSkillById(String skillId);

    Map<String,Object> searchSkills(String keyword);

    ResponseEntity<?> deleteSkill(Long skillId);
}