package com.mark43.userdashboard.user.service.project;

import com.mark43.auth.utils.AuthUtil;
import com.mark43.exception.custom.ResourceNotFoundException;
import com.mark43.userdashboard.user.dto.project.ProjectDto;

import com.mark43.userdashboard.user.dto.project.ProjectResponseDto;
import com.mark43.userdashboard.user.entity.ProjectEntity;
import com.mark43.userdashboard.user.repo.ProjectRepository;
import com.mark43.utils.collectionutil.CollectionUtil;
import com.mark43.utils.datetimeutil.DateTimeUtil;
import com.mark43.utils.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public ResponseEntity<?> create(ProjectDto dto) {
        ProjectEntity entity = new ProjectEntity();
        entity.setProfile(AuthUtil.getUserProfileId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setTechnologiesUsed(dto.getTechnologiesUsed());
        entity.setProjectUrl(dto.getProjectUrl());
        entity.setGithubUrl(dto.getGithubUrl());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setCreatedAt(DateTimeUtil.currentUtcDateTime());
        entity.setCreatedBy(AuthUtil.getUserProfileId());
        this.projectRepository.save(entity);
        return ResponseUtils.created(ResponseUtils.CREATED_SUCCESSFULLY,null);

    }

    @Override
    public ResponseEntity<?> update(UUID uniqueId, ProjectDto dto) {
        ProjectEntity entity = this.projectRepository.findByUniqueId(uniqueId).orElseThrow(()-> new  ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        entity.setProfile(AuthUtil.getUserProfileId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setTechnologiesUsed(dto.getTechnologiesUsed());
        entity.setProjectUrl(dto.getProjectUrl());
        entity.setGithubUrl(dto.getGithubUrl());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setUpdatedAt(DateTimeUtil.currentUtcDateTime());
        entity.setUpdatedBy(AuthUtil.getUserProfileId());
        this.projectRepository.save(entity);
        return ResponseUtils.created(ResponseUtils.UPDATED_SUCCESSFULLY,null);

    }

    @Override
    public ResponseEntity<?> getAllByUser() {
        Map<String, Object> response = new HashMap<>();
        List<ProjectResponseDto> data_array = new LinkedList<>();
        List<ProjectEntity> dataList = this.projectRepository.findByProfileId(AuthUtil.getUserProfileId());
        if (CollectionUtil.isNotEmpty(dataList)){
            for (ProjectEntity entity :dataList){
                ProjectResponseDto responseDto = new ProjectResponseDto();
                responseDto.setProfile(AuthUtil.getUserProfileId());
                responseDto.setTitle(entity.getTitle());
                responseDto.setDescription(entity.getDescription());
                responseDto.setTechnologiesUsed(entity.getTechnologiesUsed());
                responseDto.setProjectUrl(entity.getProjectUrl());
                responseDto.setGithubUrl(entity.getGithubUrl());
                responseDto.setStartDate(entity.getStartDate());
                responseDto.setEndDate(entity.getEndDate());
                data_array.add(responseDto);
            }
        }
        response.put(ResponseUtils.KEY_DATA_ARRAY,data_array);
        return ResponseUtils.success(ResponseUtils.SUCCESS,response);
    }

    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {
        int rows = this.projectRepository.softDeleteByUniqueId(uniqueId, DateTimeUtil.currentUtcDateTime(), AuthUtil.getUserId());
        if(rows > 0)return ResponseUtils.success(ResponseUtils.SUCCESS,null);
        return ResponseUtils.notFound(ResponseUtils.RECORD_NOT_FOUND);
    }
}
