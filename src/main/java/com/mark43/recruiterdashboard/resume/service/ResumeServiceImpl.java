package com.mark43.recruiterdashboard.resume.service;

import com.mark43.auth.utils.AuthUtil;
import com.mark43.exception.custom.ResourceNotFoundException;
import com.mark43.recruiterdashboard.resume.dto.ResumeDto;
import com.mark43.recruiterdashboard.resume.entity.ResumeEntity;
import com.mark43.recruiterdashboard.resume.repository.ResumeRepository;
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
public class ResumeServiceImpl implements ResumeService{

    private final ResumeRepository resumeRepository;

    @Override
    public ResponseEntity<?> create(ResumeDto dto) {
        ResumeEntity resume = new ResumeEntity();
        resume.setResumeUrl(dto.getResumeUrl());
        resume.setParsedSkills(dto.getParsedSkills());
        resume.setParsedExperience(dto.getParsedExperience());
        resume.setAtsScore(dto.getAtsScore());
        resume.setActive(dto.getActive());
        resumeRepository.save(resume);
        return ResponseUtils.created(ResponseUtils.CREATED_SUCCESSFULLY,resume);
    }

    @Override
    public ResponseEntity<?> update(UUID uniqueId, ResumeDto dto) {
        ResumeEntity resume = resumeRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        resume.setResumeUrl(dto.getResumeUrl());
        resume.setParsedSkills(dto.getParsedSkills());
        resume.setParsedExperience(dto.getParsedExperience());
        resume.setAtsScore(dto.getAtsScore());
        resume.setActive(dto.getActive());
        resumeRepository.save(resume);
        return ResponseUtils.success(ResponseUtils.UPDATED_SUCCESSFULLY,resume);
    }

    @Override
    public ResponseEntity<?> getAll(Map<String, Object> params) {
        List<ResumeDto> responseDto = new LinkedList<>();
        List<ResumeEntity> resumeList = resumeRepository.findAll();
        for (ResumeEntity resume : resumeList) {
            ResumeDto dto = new ResumeDto();
            dto.setUniqueId(resume.getUniqueId());
            dto.setResumeUrl(resume.getResumeUrl());
            dto.setParsedSkills(resume.getParsedSkills());
            dto.setParsedExperience(resume.getParsedExperience());
            dto.setAtsScore(resume.getAtsScore());
            dto.setActive(resume.getActive());
            responseDto.add(dto);
        }
        return ResponseUtils.success(ResponseUtils.SUCCESS,responseDto);
    }

    @Override
    public ResponseEntity<?> getByUniqueId(UUID uniqueId) {
        ResumeEntity resume = resumeRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        ResumeDto dto = new ResumeDto();
        dto.setUniqueId(resume.getUniqueId());
        dto.setResumeUrl(resume.getResumeUrl());
        dto.setParsedSkills(resume.getParsedSkills());
        dto.setParsedExperience(resume.getParsedExperience());
        dto.setAtsScore(resume.getAtsScore());
        dto.setActive(resume.getActive());
        return ResponseUtils.success(ResponseUtils.SUCCESS,dto);
    }

    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {
        int rows = this.resumeRepository.softDeleteByUniqueId(uniqueId, DateTimeUtil.currentUtcDateTime(), AuthUtil.getUserId());
        if(rows > 0)return ResponseUtils.success(ResponseUtils.SUCCESS,null);
        return ResponseUtils.notFound(ResponseUtils.RECORD_NOT_FOUND);
    }
}
