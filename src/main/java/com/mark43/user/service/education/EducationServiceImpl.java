package com.mark43.user.service.education;

import com.mark43.auth.utils.AuthUtil;
import com.mark43.exception.custom.ResourceNotFoundException;
import com.mark43.user.dto.EducationDto;
import com.mark43.user.dto.education.EducationResponseDto;
import com.mark43.user.entity.CertificationEntity;
import com.mark43.user.entity.EducationEntity;
import com.mark43.user.repo.EducationRepository;
import com.mark43.utils.collectionutil.CollectionUtil;
import com.mark43.utils.datetimeutil.DateTimeUtil;
import com.mark43.utils.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService{

    private final EducationRepository educationRepository;

    @Override
    public ResponseEntity<?> create(EducationDto dto) {
        EducationEntity entity = new EducationEntity();
        entity.setInstituteName(dto.getInstituteName());
        entity.setDegree(dto.getDegree());
        entity.setFieldOfStudy(dto.getFieldOfStudy());
        entity.setPercentage(dto.getPercentage());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setCurrentlyPursuing(dto.getCurrentlyPursuing());
        entity.setProfile(AuthUtil.getUserProfileId());
        entity.setCreatedAt(DateTimeUtil.currentUtcDateTime());
        entity.setCreatedBy(AuthUtil.getUserId());

        educationRepository.save(entity);
        return ResponseUtils.created(ResponseUtils.CREATED_SUCCESSFULLY,null);
    }

    @Override
    public ResponseEntity<?> update(UUID uniqueId, EducationDto dto) {
        EducationEntity entity = this.educationRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        entity.setInstituteName(dto.getInstituteName());
        entity.setDegree(dto.getDegree());
        entity.setFieldOfStudy(dto.getFieldOfStudy());
        entity.setPercentage(dto.getPercentage());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setCurrentlyPursuing(dto.getCurrentlyPursuing());
        entity.setProfile(AuthUtil.getUserProfileId());
        entity.setUpdatedAt(DateTimeUtil.currentUtcDateTime());
        entity.setUpdatedBy(AuthUtil.getUserId());
        educationRepository.save(entity);
        return ResponseUtils.created(ResponseUtils.UPDATED_SUCCESSFULLY,null);
    }

    @Override
    public ResponseEntity<?> getAllByUser() {
        Map<String, Object> response = new HashMap<>();
        List<Map<String, Object>> data_array = new LinkedList<>();
        List<EducationEntity> dataList = educationRepository.findByProfileId(AuthUtil.getUserProfileId());
        if (CollectionUtil.isNotEmpty(dataList)){
            for (EducationEntity entity :dataList){
                EducationResponseDto dto = new EducationResponseDto();
                dto.setUniqueId(entity.getUniqueId());
                dto.setInstituteName(entity.getInstituteName());
                dto.setDegree(entity.getDegree());
                dto.setFieldOfStudy(entity.getFieldOfStudy());
                dto.setPercentage(entity.getPercentage());
                dto.setStartDate(entity.getStartDate());
                dto.setEndDate(entity.getEndDate());
                dto.setCurrentlyPursuing(entity.getCurrentlyPursuing());
            }
        }
        response.put(ResponseUtils.KEY_DATA_ARRAY,data_array);
        return ResponseUtils.success(ResponseUtils.SUCCESS,response);
    }

    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {
        int rows = this.educationRepository.softDeleteByUniqueId(uniqueId, DateTimeUtil.currentUtcDateTime(), AuthUtil.getUserId());
        if(rows > 0)return ResponseUtils.success(ResponseUtils.SUCCESS,null);
        return ResponseUtils.notFound(ResponseUtils.RECORD_NOT_FOUND);
    }
}
