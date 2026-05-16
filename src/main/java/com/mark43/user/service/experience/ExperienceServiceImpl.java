package com.mark43.user.service.experience;

import com.mark43.auth.utils.AuthUtil;
import com.mark43.exception.custom.ResourceNotFoundException;
import com.mark43.user.dto.ExperienceDto;
import com.mark43.user.dto.education.EducationResponseDto;
import com.mark43.user.dto.experience.ExperienceResponseDto;
import com.mark43.user.entity.EducationEntity;
import com.mark43.user.entity.ExperienceEntity;
import com.mark43.user.repo.ExperienceRepository;
import com.mark43.utils.collectionutil.CollectionUtil;
import com.mark43.utils.datetimeutil.DateTimeUtil;
import com.mark43.utils.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService{

    private final ExperienceRepository experienceRepository;

    @Override
    public ResponseEntity<?> create(ExperienceDto dto) {
        ExperienceEntity entity = new ExperienceEntity();
        entity.setCompanyName(dto.getCompanyName());
        entity.setDesignation(dto.getDesignation());
        entity.setResponsibilities(dto.getResponsibilities());
        entity.setEmploymentType(dto.getEmploymentType());
        entity.setLocation(dto.getLocation());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setCurrentlyWorking(dto.getCurrentlyWorking());
        entity.setProfile(AuthUtil.getUserProfileId());
        entity.setCreatedAt(DateTimeUtil.currentUtcDateTime());
        entity.setCreatedBy(AuthUtil.getUserProfileId());
        this.experienceRepository.save(entity);
        return ResponseUtils.created(ResponseUtils.CREATED_SUCCESSFULLY,null);

    }

    @Override
    public ResponseEntity<?> update(UUID uniqueId, ExperienceDto dto) {
        ExperienceEntity entity = this.experienceRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        entity.setCompanyName(dto.getCompanyName());
        entity.setDesignation(dto.getDesignation());
        entity.setResponsibilities(dto.getResponsibilities());
        entity.setEmploymentType(dto.getEmploymentType());
        entity.setLocation(dto.getLocation());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setCurrentlyWorking(dto.getCurrentlyWorking());
        entity.setUpdatedAt(DateTimeUtil.currentUtcDateTime());
        entity.setUpdatedBy(AuthUtil.getUserProfileId());
        this.experienceRepository.save(entity);
        return ResponseUtils.created(ResponseUtils.UPDATED_SUCCESSFULLY,null);
    }

    @Override
    public ResponseEntity<?> getAllByUser() {
        Map<String, Object> response = new HashMap<>();
        List<ExperienceResponseDto> data_array = new LinkedList<>();
        List<ExperienceEntity> dataList = this.experienceRepository.findByProfileId(AuthUtil.getUserProfileId());
        if (CollectionUtil.isNotEmpty(dataList)){
            for (ExperienceEntity entity :dataList){
                ExperienceResponseDto responseDto = new ExperienceResponseDto();
                responseDto.setCompanyName(entity.getCompanyName());
                responseDto.setDesignation(entity.getDesignation());
                responseDto.setResponsibilities(entity.getResponsibilities());
                responseDto.setEmploymentType(entity.getEmploymentType());
                responseDto.setLocation(entity.getLocation());
                responseDto.setStartDate(entity.getStartDate());
                responseDto.setEndDate(entity.getEndDate());
                responseDto.setCurrentlyWorking(entity.getCurrentlyWorking());
                data_array.add(responseDto);
            }
        }
        response.put(ResponseUtils.KEY_DATA_ARRAY,data_array);
        return ResponseUtils.success(ResponseUtils.SUCCESS,response);
    }

    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {
        int rows = this.experienceRepository.softDeleteByUniqueId(uniqueId, DateTimeUtil.currentUtcDateTime(), AuthUtil.getUserId());
        if(rows > 0)return ResponseUtils.success(ResponseUtils.SUCCESS,null);
        return ResponseUtils.notFound(ResponseUtils.RECORD_NOT_FOUND);
    }
}
