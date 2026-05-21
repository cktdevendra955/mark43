package com.mark43.user.service.userskill;


import com.mark43.user.dto.skill.UserSkillDto;
import com.mark43.user.entity.UserSkillEntity;
import com.mark43.user.repo.UserSkillRepository;
import com.mark43.utils.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserSkillServiceImpl implements UserSkillService {

    private final UserSkillRepository userSkillRepository;

    @Override
    public ResponseEntity<?> create(UserSkillDto dto) {
        UserSkillEntity entity = new UserSkillEntity();
        entity.setSkillId(dto.getSkillId());
        entity.setProficiencyLevel(dto.getProficiencyLevel());
        entity.setProfileId(dto.getProfileId());
        entity.setExperienceYears(dto.getExperienceYears());
        this.userSkillRepository.save(entity);
        return ResponseUtils.created(ResponseUtils.CREATED_SUCCESSFULLY,null);
    }

    @Override
    public ResponseEntity<?> getAllByUser() {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {
        int rows = this.userSkillRepository.hardDeleteByUniqueId(uniqueId);
        if(rows > 0)return ResponseUtils.success(ResponseUtils.SUCCESS,null);
        return ResponseUtils.notFound(ResponseUtils.RECORD_NOT_FOUND);
    }
}