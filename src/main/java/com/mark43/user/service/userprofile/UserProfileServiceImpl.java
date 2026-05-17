package com.mark43.user.service.userprofile;

import com.mark43.auth.utils.AuthUtil;
import com.mark43.exception.custom.ResourceNotFoundException;
import com.mark43.user.dto.project.ProjectDto;
import com.mark43.user.dto.userprofile.UserProfileDto;
import com.mark43.user.entity.ProjectEntity;
import com.mark43.user.entity.UserProfileEntity;
import com.mark43.user.repo.UserProfileRepository;
import com.mark43.utils.datetimeutil.DateTimeUtil;
import com.mark43.utils.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService{

    private final UserProfileRepository userProfileRepository;
    @Override
    public ResponseEntity<?> create(UserProfileDto dto) {
        UserProfileEntity entity = new UserProfileEntity();
        entity.setUserId(AuthUtil.getUserId());
        entity.setHeadline(dto.getHeadline());
        entity.setSummary(dto.getSummary());
        entity.setTotalExperience(dto.getTotalExperience());
        entity.setCurrentCompany(dto.getCurrentCompany());
        entity.setCurrentDesignation(dto.getCurrentDesignation());
        entity.setHighestEducation(dto.getHighestEducation());
        entity.setExpectedSalary(dto.getExpectedSalary());
        entity.setCurrentSalary(dto.getCurrentSalary());
        entity.setNoticePeriod(dto.getNoticePeriod());
        entity.setProfilePhoto(dto.getProfilePhoto());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setGender(dto.getGender());
        entity.setMaritalStatus(dto.getMaritalStatus());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setCountry(dto.getCountry());
        entity.setPincode(dto.getPincode());
        entity.setOpenToWork(dto.getOpenToWork());
        entity.setProfileCompleted(dto.getProfileCompleted());
        entity.setCreatedAt(DateTimeUtil.currentUtcDateTime());
        entity.setCreatedBy(AuthUtil.getUserProfileId());
        this.userProfileRepository.save(entity);
        return ResponseUtils.created(ResponseUtils.CREATED_SUCCESSFULLY,null);
    }

    @Override
    public ResponseEntity<?> update(UUID uniqueId, UserProfileDto dto) {
        UserProfileEntity entity = this.userProfileRepository.findByUniqueId(uniqueId).orElseThrow(()-> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        entity.setHeadline(dto.getHeadline());
        entity.setSummary(dto.getSummary());
        entity.setTotalExperience(dto.getTotalExperience());
        entity.setCurrentCompany(dto.getCurrentCompany());
        entity.setCurrentDesignation(dto.getCurrentDesignation());
        entity.setHighestEducation(dto.getHighestEducation());
        entity.setExpectedSalary(dto.getExpectedSalary());
        entity.setCurrentSalary(dto.getCurrentSalary());
        entity.setNoticePeriod(dto.getNoticePeriod());
        entity.setProfilePhoto(dto.getProfilePhoto());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setGender(dto.getGender());
        entity.setMaritalStatus(dto.getMaritalStatus());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setCountry(dto.getCountry());
        entity.setPincode(dto.getPincode());
        entity.setOpenToWork(dto.getOpenToWork());
        entity.setProfileCompleted(dto.getProfileCompleted());
        entity.setUpdatedAt(DateTimeUtil.currentUtcDateTime());
        entity.setUpdatedBy(AuthUtil.getUserProfileId());
        this.userProfileRepository.save(entity);
        return ResponseUtils.created(ResponseUtils.UPDATED_SUCCESSFULLY,null);

    }

    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {
        int rows = this.userProfileRepository.softDeleteByUniqueId(uniqueId, DateTimeUtil.currentUtcDateTime(), AuthUtil.getUserId());
        if(rows > 0)return ResponseUtils.success(ResponseUtils.SUCCESS,null);
        return ResponseUtils.notFound(ResponseUtils.RECORD_NOT_FOUND);
    }
}
