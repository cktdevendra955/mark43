package com.mark43.recruiterdashboard.hiringdrives.service;

import com.mark43.recruiterdashboard.hiringdrives.dto.HiringDriveDto;
import com.mark43.recruiterdashboard.hiringdrives.entity.HiringDriveEntity;
import com.mark43.recruiterdashboard.hiringdrives.repository.HiringDriveRepository;
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
public class HiringDriveServiceImpl implements HiringDriveService {

    private final HiringDriveRepository hiringDriveRepository;

    @Override
    public ResponseEntity<?> create(HiringDriveDto dto) {
        HiringDriveEntity entity = new HiringDriveEntity();
        setEntityData(entity, dto);
        hiringDriveRepository.save(entity);
        return ResponseUtils.created("Hiring drive created successfully",null);
    }

    @Override
    public ResponseEntity<?> update(UUID uniqueId, HiringDriveDto dto) {

        Optional<HiringDriveEntity> optional =hiringDriveRepository.findByUniqueId(uniqueId);
        if (optional.isEmpty()) {return ResponseUtils.notFound("Hiring drive not found");}

        HiringDriveEntity entity = optional.get();
        setEntityData(entity, dto);
        hiringDriveRepository.save(entity);
        return ResponseUtils.success("Hiring drive updated successfully",entity);
    }

    @Override
    public ResponseEntity<?> getAll(Map<String, Object> params) {
        List<HiringDriveEntity> data =hiringDriveRepository.findAll();
        return ResponseUtils.success("Hiring drive list fetched successfully",data);
    }

    @Override
    public ResponseEntity<?> getByUniqueId(UUID uniqueId) {

        Optional<HiringDriveEntity> optional = hiringDriveRepository.findByUniqueId(uniqueId);
        if (optional.isEmpty()) {
            return ResponseUtils.notFound("Hiring drive not found");
        }
        return ResponseUtils.success("Hiring drive fetched successfully",optional.get());
    }

    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {

        Optional<HiringDriveEntity> optional = hiringDriveRepository.findByUniqueId(uniqueId);
        if (optional.isEmpty()) {
            return ResponseUtils.notFound("Hiring drive not found");
        }
        hiringDriveRepository.delete(optional.get());
        return ResponseUtils.success("Hiring drive deleted successfully",null);
    }

    @Override
    public ResponseEntity<?> changeStatus(UUID uniqueId,String status) {
        Optional<HiringDriveEntity> optional = hiringDriveRepository.findByUniqueId(uniqueId);
        if (optional.isEmpty()) {
            return ResponseUtils.notFound("Hiring drive not found");
        }

        HiringDriveEntity entity = optional.get();
        entity.setStatus(status);
        hiringDriveRepository.save(entity);
        return ResponseUtils.success("Hiring drive status updated successfully",entity);
    }

    @Override
    public ResponseEntity<?> getFeatured() {
        List<HiringDriveEntity> data = hiringDriveRepository.findByFeaturedTrue();
        return ResponseUtils.success("Featured hiring drives fetched successfully",data);
    }

    @Override
    public ResponseEntity<?> search(String keyword) {
        List<HiringDriveEntity> data =hiringDriveRepository.findByJobRoleContainingIgnoreCase(keyword);
        return ResponseUtils.success("Hiring drive search result fetched successfully",data);
    }

    private void setEntityData(HiringDriveEntity entity,HiringDriveDto dto) {
        entity.setTitle(dto.getTitle());
        entity.setCompanyName(dto.getCompanyName());
        entity.setDescription(dto.getDescription());
        entity.setHiringType(dto.getHiringType());
        entity.setJobRole(dto.getJobRole());
        entity.setExperience(dto.getExperience());
        entity.setPackageOffered(dto.getPackageOffered());
        entity.setLocation(dto.getLocation());
        entity.setEligibilityCriteria(dto.getEligibilityCriteria());
        entity.setLastApplyDate(dto.getLastApplyDate());
        entity.setDriveDate(dto.getDriveDate());
        entity.setStartDateTime(dto.getStartDateTime());
        entity.setEndDateTime(dto.getEndDateTime());
        entity.setTotalOpenings(dto.getTotalOpenings());
        entity.setCompanyWebsite(dto.getCompanyWebsite());
        entity.setRegistrationUrl(dto.getRegistrationUrl());
        entity.setVenueAddress(dto.getVenueAddress());
        entity.setContactEmail(dto.getContactEmail());
        entity.setContactPhone(dto.getContactPhone());
        entity.setBannerImage(dto.getBannerImage());
        entity.setStatus(dto.getStatus());
        entity.setFeatured(dto.getFeatured());
        entity.setTotalApplicants(dto.getTotalApplicants());
    }
}