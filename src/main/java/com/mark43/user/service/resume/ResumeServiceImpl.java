package com.mark43.user.service.resume;

import com.mark43.auth.utils.AuthUtil;
import com.mark43.exception.custom.ResourceNotFoundException;
import com.mark43.user.dto.language.UserLanguageDto;
import com.mark43.user.dto.resume.ResumeResponseDto;
import com.mark43.user.entity.ResumeEntity;
import com.mark43.user.repo.ResumeRepository;
import com.mark43.utils.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService{

    private final ResumeRepository resumeRepository;

    @Override
    public ResponseEntity<?> upload(UserLanguageDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<?> getResumeByUser() {
        ResumeEntity entity = this.resumeRepository.findByProfileId(AuthUtil.getUserProfileId()).orElseThrow(()-> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        ResumeResponseDto responseDto = new ResumeResponseDto();
        responseDto.setPrimaryResume(entity.getPrimaryResume());
        responseDto.setResumeName(entity.getResumeName());
        responseDto.setResumeUrl(entity.getResumeUrl());
        return ResponseUtils.success(ResponseUtils.SUCCESS,responseDto);
    }

    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {
        int rows = this.resumeRepository.hardDeleteByUniqueId(uniqueId);
        if(rows > 0)return ResponseUtils.success(ResponseUtils.SUCCESS,null);
        return ResponseUtils.notFound(ResponseUtils.RECORD_NOT_FOUND);
    }
}

