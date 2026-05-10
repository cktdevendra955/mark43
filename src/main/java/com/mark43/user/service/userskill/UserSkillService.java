package com.mark43.user.service.userskill;


import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserSkillService {

    ResponseEntity<?> addSkillToUser(Map<String,Object> dto);

    Map<String,Object> getUserSkills(String userId);

    ResponseEntity<?> removeUserSkill(Long userSkillId);
}