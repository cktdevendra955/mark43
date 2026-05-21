package com.mark43.common.service.jobs;
import com.mark43.common.dto.JobsDto;
import com.mark43.common.entity.jobs.JobsEntity;
import com.mark43.common.repo.jobs.JobsRepository;

import com.mark43.utils.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JobsServiceImpl implements JobsService {

    private final JobsRepository jobsRepository;

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
}