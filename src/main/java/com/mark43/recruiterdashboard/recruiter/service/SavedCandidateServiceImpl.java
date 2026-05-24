package com.mark43.recruiterdashboard.recruiter.service;

import com.mark43.auth.utils.AuthUtil;
import com.mark43.exception.custom.ResourceNotFoundException;
import com.mark43.recruiterdashboard.recruiter.dto.SavedCandidateDto;
import com.mark43.recruiterdashboard.recruiter.entity.SavedCandidateEntity;
import com.mark43.recruiterdashboard.recruiter.repository.SavedCandidateRepository;
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
public class SavedCandidateServiceImpl implements SavedCandidateService{

    private final SavedCandidateRepository savedCandidateRepository;

    @Override
    public ResponseEntity<?> create(SavedCandidateDto dto) {
        SavedCandidateEntity savedCandidate = new SavedCandidateEntity();
        savedCandidate.setNotes(dto.getNotes());
        savedCandidateRepository.save(savedCandidate);
        return ResponseUtils.created(ResponseUtils.CREATED_SUCCESSFULLY,savedCandidate);
    }

    @Override
    public ResponseEntity<?> update(UUID uniqueId, SavedCandidateDto dto) {
        SavedCandidateEntity savedCandidate = savedCandidateRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        savedCandidate.setNotes(dto.getNotes());
        savedCandidateRepository.save(savedCandidate);
        return ResponseUtils.success(ResponseUtils.UPDATED_SUCCESSFULLY,savedCandidate);
    }

    @Override
    public ResponseEntity<?> getAll(Map<String, Object> params) {
        List<SavedCandidateDto> responseDto = new LinkedList<>();
        List<SavedCandidateEntity> savedCandidateList = savedCandidateRepository.findAll();
        for (SavedCandidateEntity savedCandidate : savedCandidateList) {
            SavedCandidateDto dto = new SavedCandidateDto();
            dto.setUniqueId(savedCandidate.getUniqueId());
            dto.setNotes(savedCandidate.getNotes());
            responseDto.add(dto);
        }
        return ResponseUtils.success(ResponseUtils.SUCCESS,responseDto);
    }
    @Override
    public ResponseEntity<?> getByUniqueId(UUID uniqueId) {
        SavedCandidateEntity savedCandidate = savedCandidateRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        SavedCandidateDto dto = new SavedCandidateDto();
        dto.setUniqueId(savedCandidate.getUniqueId());
        dto.setNotes(savedCandidate.getNotes());
        return ResponseUtils.success(ResponseUtils.SUCCESS,dto);
    }

    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {
        int rows = this.savedCandidateRepository.softDeleteByUniqueId(uniqueId, DateTimeUtil.currentUtcDateTime(), AuthUtil.getUserId());
        if(rows > 0)return ResponseUtils.success(ResponseUtils.SUCCESS,null);
        return ResponseUtils.notFound(ResponseUtils.RECORD_NOT_FOUND);
    }
}
