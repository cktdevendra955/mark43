package com.mark43.user.service.userskill;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserSkillServiceImpl implements UserSkillService {

    @Override
    public ResponseEntity<?> addSkillToUser(Map<String, Object> dto) {
        return null;
    }

    @Override
    public Map<String, Object> getUserSkills(String userId) {
        return Map.of();
    }

    @Override
    public ResponseEntity<?> removeUserSkill(Long userSkillId) {
        return null;
    }
}