package com.mark43.recruiterdashboard.recruiter.service;

import com.mark43.auth.utils.AuthUtil;
import com.mark43.exception.custom.ResourceNotFoundException;
import com.mark43.recruiterdashboard.recruiter.dto.RecruiterProfileDto;
import com.mark43.recruiterdashboard.recruiter.entity.RecruiterProfileEntity;
import com.mark43.recruiterdashboard.recruiter.repository.RecruiterProfileRepository;
import com.mark43.utils.datetimeutil.DateTimeUtil;
import com.mark43.utils.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecruiterProfileServiceImpl implements RecruiterProfileService{
    private final RecruiterProfileRepository recruiterProfileRepository;

    @Override
    public ResponseEntity<?> create(RecruiterProfileDto dto) {
        RecruiterProfileEntity recruiter = new RecruiterProfileEntity();
        recruiter.setDesignation(dto.getDesignation());
        recruiter.setDepartment(dto.getDepartment());
        recruiter.setRecruiterType(dto.getRecruiterType());
        recruiter.setVerified(dto.getVerified());
        recruiter.setActive(dto.getActive());
        recruiterProfileRepository.save(recruiter);
        return ResponseUtils.created(ResponseUtils.CREATED_SUCCESSFULLY,recruiter);
    }

    @Override
    public ResponseEntity<?> update(UUID uniqueId, RecruiterProfileDto dto) {
        RecruiterProfileEntity recruiter = recruiterProfileRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        recruiter.setDesignation(dto.getDesignation());
        recruiter.setDepartment(dto.getDepartment());
        recruiter.setRecruiterType(dto.getRecruiterType());
        recruiter.setVerified(dto.getVerified());
        recruiter.setActive(dto.getActive());
        recruiterProfileRepository.save(recruiter);
        return ResponseUtils.success(ResponseUtils.UPDATED_SUCCESSFULLY,recruiter);
    }

    @Override
    public ResponseEntity<?> getAll(Map<String, Object> params) {
        List<RecruiterProfileDto> responseDto = new LinkedList<>();
        List<RecruiterProfileEntity> recruiterList = recruiterProfileRepository.findAll();
        for (RecruiterProfileEntity recruiter : recruiterList) {
            RecruiterProfileDto dto = new RecruiterProfileDto();
            dto.setUniqueId(recruiter.getUniqueId());
            dto.setDesignation(recruiter.getDesignation());
            dto.setDepartment(recruiter.getDepartment());
            dto.setRecruiterType(recruiter.getRecruiterType());
            dto.setVerified(recruiter.getVerified());
            dto.setActive(recruiter.getActive());
            responseDto.add(dto);
        }
        return ResponseUtils.success(ResponseUtils.SUCCESS,responseDto);
    }

    @Override
    public ResponseEntity<?> getByUniqueId(UUID uniqueId) {
        RecruiterProfileEntity recruiter = recruiterProfileRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        RecruiterProfileDto dto = new RecruiterProfileDto();
        dto.setUniqueId(recruiter.getUniqueId());
        dto.setDesignation(recruiter.getDesignation());
        dto.setDepartment(recruiter.getDepartment());
        dto.setRecruiterType(recruiter.getRecruiterType());
        dto.setVerified(recruiter.getVerified());
        dto.setActive(recruiter.getActive());
        return ResponseUtils.success(ResponseUtils.SUCCESS,dto);
    }

    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {
        int rows = this.recruiterProfileRepository.softDeleteByUniqueId(uniqueId, DateTimeUtil.currentUtcDateTime(), AuthUtil.getUserId());
        if(rows > 0)return ResponseUtils.success(ResponseUtils.SUCCESS,null);
        return ResponseUtils.notFound(ResponseUtils.RECORD_NOT_FOUND);
    }
}
