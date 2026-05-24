package com.mark43.recruiterdashboard.jobs.service;
import com.mark43.auth.utils.AuthUtil;
import com.mark43.exception.custom.ResourceNotFoundException;
import com.mark43.recruiterdashboard.jobs.dto.ApplicationStatusHistoryDto;
import com.mark43.recruiterdashboard.jobs.dto.JobApplicationDto;
import com.mark43.recruiterdashboard.jobs.dto.JobsDto;
import com.mark43.recruiterdashboard.jobs.entity.ApplicationStatusHistoryEntity;
import com.mark43.recruiterdashboard.jobs.entity.JobApplicationEntity;
import com.mark43.recruiterdashboard.jobs.entity.JobsEntity;
import com.mark43.recruiterdashboard.jobs.repository.ApplicationStatusHistoryRepository;
import com.mark43.recruiterdashboard.jobs.repository.JobApplicationRepository;
import com.mark43.recruiterdashboard.jobs.repository.JobsRepository;

import com.mark43.utils.datetimeutil.DateTimeUtil;
import com.mark43.utils.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class JobsServiceImpl implements JobsService {

    private final JobsRepository jobsRepository;
    private final JobApplicationRepository jobApplicationRepository;
    private final ApplicationStatusHistoryRepository applicationStatusHistoryRepository;

    @Override
    public ResponseEntity<?> create(JobsDto dto) {
        JobsEntity entity = new JobsEntity();
        setEntityData(entity, dto);
        jobsRepository.save(entity);
        return ResponseUtils.created("Job created successfully",entity);
    }

    @Override
    public ResponseEntity<?> update(UUID uniqueId,JobsDto dto) {
        Optional<JobsEntity> optional = jobsRepository.findByUniqueId(uniqueId);
        if (optional.isEmpty()) {
            return ResponseUtils.notFound("Job not found");
        }

        JobsEntity entity = optional.get();
        setEntityData(entity, dto);
        jobsRepository.save(entity);
        return ResponseUtils.success("Job updated successfully",entity);
    }

    @Override
    public ResponseEntity<?> getAll(Map<String, Object> params) {
        List<JobsEntity> data =jobsRepository.findAll();
        return ResponseUtils.success("Jobs fetched successfully",data);
    }

    @Override
    public ResponseEntity<?> getByUniqueId(UUID uniqueId) {
        Optional<JobsEntity> optional =jobsRepository.findByUniqueId(uniqueId);
        if (optional.isEmpty()) {
            return ResponseUtils.notFound("Job not found");
        }
        return ResponseUtils.success("Job fetched successfully",optional.get());
    }

    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {
        Optional<JobsEntity> optional =jobsRepository.findByUniqueId(uniqueId);
        if (optional.isEmpty()) {
            return ResponseUtils.notFound("Job not found");
        }
        jobsRepository.delete(optional.get());
        return ResponseUtils.success("Job deleted successfully",null);
    }

    @Override
    public ResponseEntity<?> changeStatus(UUID uniqueId,String status) {
        Optional<JobsEntity> optional =jobsRepository.findByUniqueId(uniqueId);
        if (optional.isEmpty()) {
            return ResponseUtils.notFound("Job not found");
        }
        JobsEntity entity = optional.get();
        entity.setStatus(status);
        jobsRepository.save(entity);
        return ResponseUtils.success("Job status updated successfully",entity);
    }

    @Override
    public ResponseEntity<?> getFeatured() {
        return ResponseUtils.success("Featured jobs fetched successfully",jobsRepository.findByFeaturedTrue());
    }

    @Override
    public ResponseEntity<?> getUrgentHiring() {
        return ResponseUtils.success("Urgent hiring jobs fetched successfully",jobsRepository.findByUrgentHiringTrue());
    }

    @Override
    public ResponseEntity<?> getActiveJobs() {
        return ResponseUtils.success("Active jobs fetched successfully",jobsRepository.findByActiveTrue());
    }

    @Override
    public ResponseEntity<?> search(String keyword) {
        return ResponseUtils.success("Jobs fetched successfully",jobsRepository.findByTitleContainingIgnoreCase(keyword));
    }

    private void setEntityData(JobsEntity entity,JobsDto dto) {
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setCompanyName(dto.getCompanyName());
        entity.setJobType(dto.getJobType());
        entity.setWorkMode(dto.getWorkMode());
        entity.setExperience(dto.getExperience());
        entity.setSalary(dto.getSalary());
        entity.setLocation(dto.getLocation());
        entity.setOpenings(dto.getOpenings());
        entity.setQualification(dto.getQualification());
        entity.setResponsibilities(dto.getResponsibilities());
        entity.setRequirements(dto.getRequirements());
        entity.setLastApplyDate(dto.getLastApplyDate());
        entity.setCompanyWebsite(dto.getCompanyWebsite());
        entity.setCompanyLogo(dto.getCompanyLogo());
        entity.setApplicationUrl(dto.getApplicationUrl());
        entity.setFeatured(dto.getFeatured());
        entity.setUrgentHiring(dto.getUrgentHiring());
        entity.setActive(dto.getActive());
        entity.setTotalApplications(dto.getTotalApplications());
        entity.setStatus(dto.getStatus());
    }


    @Override
    public ResponseEntity<?> jobApplicationCreate(JobApplicationDto dto) {
        JobApplicationEntity application = new JobApplicationEntity();
        application.setResumeUrl(dto.getResumeUrl());
        application.setCoverLetter(dto.getCoverLetter());
        application.setStatus(dto.getStatus());
        application.setAppliedVia(dto.getAppliedVia());
        application.setViewed(dto.getViewed());
        application.setShortlisted(dto.getShortlisted());
        application.setRejected(dto.getRejected());
        jobApplicationRepository.save(application);
        return ResponseUtils.created(ResponseUtils.CREATED_SUCCESSFULLY,application);
    }

    @Override
    public ResponseEntity<?> jobApplicationUpdate(UUID uniqueId, JobApplicationDto dto) {
        JobApplicationEntity application = jobApplicationRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        application.setResumeUrl(dto.getResumeUrl());
        application.setCoverLetter(dto.getCoverLetter());
        application.setStatus(dto.getStatus());
        application.setAppliedVia(dto.getAppliedVia());
        application.setViewed(dto.getViewed());
        application.setShortlisted(dto.getShortlisted());
        application.setRejected(dto.getRejected());
        jobApplicationRepository.save(application);
        return ResponseUtils.success(ResponseUtils.UPDATED_SUCCESSFULLY,application);
    }

    @Override
    public ResponseEntity<?> jobApplicationGetAll(Map<String, Object> params) {
        List<JobApplicationDto> responseDto = new LinkedList<>();
        List<JobApplicationEntity> applicationList = jobApplicationRepository.findAll();
        for (JobApplicationEntity application : applicationList) {
            JobApplicationDto dto = new JobApplicationDto();
            dto.setUniqueId(application.getUniqueId());
            dto.setResumeUrl(application.getResumeUrl());
            dto.setCoverLetter(application.getCoverLetter());
            dto.setStatus(application.getStatus());
            dto.setAppliedVia(application.getAppliedVia());
            dto.setViewed(application.getViewed());
            dto.setShortlisted(application.getShortlisted());
            dto.setRejected(application.getRejected());
            responseDto.add(dto);
        }
        return ResponseUtils.success(ResponseUtils.SUCCESS,responseDto);
    }
    @Override
    public ResponseEntity<?> jobApplicationGetByUniqueId(UUID uniqueId) {
        JobApplicationEntity application = jobApplicationRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        JobApplicationDto dto = new JobApplicationDto();
        dto.setUniqueId(application.getUniqueId());
        dto.setResumeUrl(application.getResumeUrl());
        dto.setCoverLetter(application.getCoverLetter());
        dto.setStatus(application.getStatus());
        dto.setAppliedVia(application.getAppliedVia());
        dto.setViewed(application.getViewed());
        dto.setShortlisted(application.getShortlisted());
        dto.setRejected(application.getRejected());
        return ResponseUtils.success(ResponseUtils.SUCCESS,dto);
    }

    @Override
    public ResponseEntity<?> jobApplicationDelete(UUID uniqueId) {
        int rows = this.jobApplicationRepository.softDeleteByUniqueId(uniqueId, DateTimeUtil.currentUtcDateTime(), AuthUtil.getUserId());
        if(rows > 0)return ResponseUtils.success(ResponseUtils.SUCCESS,null);
        return ResponseUtils.notFound(ResponseUtils.RECORD_NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> jobApplicationChangeStatus(UUID uniqueId, String status) {
        JobApplicationEntity application = jobApplicationRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        application.setStatus(status);
        jobApplicationRepository.save(application);
        return ResponseUtils.success(ResponseUtils.UPDATED_SUCCESSFULLY,application);
    }

    @Override
    public ResponseEntity<?> applicationStatusHistoryCreate(ApplicationStatusHistoryDto dto) {
        ApplicationStatusHistoryEntity history = new ApplicationStatusHistoryEntity();
        history.setOldStatus(dto.getOldStatus());
        history.setNewStatus(dto.getNewStatus());
        history.setRemarks(dto.getRemarks());
        applicationStatusHistoryRepository.save(history);
        return ResponseUtils.created(ResponseUtils.CREATED_SUCCESSFULLY,history);
    }
    @Override
    public ResponseEntity<?> applicationStatusHistoryUpdate(UUID uniqueId, ApplicationStatusHistoryDto dto) {
        ApplicationStatusHistoryEntity history = applicationStatusHistoryRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        history.setOldStatus(dto.getOldStatus());
        history.setNewStatus(dto.getNewStatus());
        history.setRemarks(dto.getRemarks());
        applicationStatusHistoryRepository.save(history);
        return ResponseUtils.success(ResponseUtils.UPDATED_SUCCESSFULLY,history);
    }
    @Override
    public ResponseEntity<?> applicationStatusHistoryGetAll(Map<String, Object> params) {
        List<ApplicationStatusHistoryDto> responseDto = new LinkedList<>();
        List<ApplicationStatusHistoryEntity> historyList = applicationStatusHistoryRepository.findAll();
        for (ApplicationStatusHistoryEntity history : historyList) {
            ApplicationStatusHistoryDto dto = new ApplicationStatusHistoryDto();
            dto.setUniqueId(history.getUniqueId());
            dto.setOldStatus(history.getOldStatus());
            dto.setNewStatus(history.getNewStatus());
            dto.setRemarks(history.getRemarks());
            responseDto.add(dto);
        }
        return ResponseUtils.success(ResponseUtils.SUCCESS,responseDto);
    }
    @Override
    public ResponseEntity<?> applicationStatusHistoryGetByUniqueId(UUID uniqueId) {
        ApplicationStatusHistoryEntity history = applicationStatusHistoryRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        ApplicationStatusHistoryDto dto = new ApplicationStatusHistoryDto();
        dto.setUniqueId(history.getUniqueId());
        dto.setOldStatus(history.getOldStatus());
        dto.setNewStatus(history.getNewStatus());
        dto.setRemarks(history.getRemarks());
        return ResponseUtils.success(ResponseUtils.SUCCESS,dto);
    }

    @Override
    public ResponseEntity<?> applicationStatusHistoryDelete(UUID uniqueId) {
        int rows = this.applicationStatusHistoryRepository.softDeleteByUniqueId(uniqueId, DateTimeUtil.currentUtcDateTime(), AuthUtil.getUserId());
        if(rows > 0)return ResponseUtils.success(ResponseUtils.SUCCESS,null);
        return ResponseUtils.notFound(ResponseUtils.RECORD_NOT_FOUND);
    }
}