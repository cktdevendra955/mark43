package com.mark43.user.service.skill;


import com.mark43.user.dto.SkillResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {


    @Override
    public ResponseEntity<?> createSkill(SkillResponseDto dto) {
        return null;
    }

    @Override
    public Map<String, Object> getAllSkills() {
        return Map.of();
    }

    @Override
    public Map<String, Object> getSkillById(String skillId) {
        return Map.of();
    }

    @Override
    public Map<String, Object> searchSkills(String keyword) {
        return Map.of();
    }

    @Override
    public ResponseEntity<?> deleteSkill(Long skillId) {
        return null;
    }
}