package com.mark43.user.service.skill;


import com.mark43.auth.utils.AuthUtil;
import com.mark43.user.dto.language.UserLanguageDto;
import com.mark43.user.dto.language.UserLanguageResponseDto;
import com.mark43.user.dto.skill.SkillDto;
import com.mark43.user.dto.skill.SkillResponseDto;
import com.mark43.user.entity.SkillEntity;
import com.mark43.user.entity.UserLanguageEntity;
import com.mark43.user.repo.SkillRepository;
import com.mark43.user.repo.UserLanguageRepository;
import com.mark43.utils.collectionutil.CollectionUtil;
import com.mark43.utils.datetimeutil.DateTimeUtil;
import com.mark43.utils.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    @Override
    public ResponseEntity<?> create(SkillDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAllByUser() {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {
        return null;
    }
}