package com.mark43.common.hiringdrives.repository;

import com.mark43.common.hiringdrives.entity.HiringDriveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface HiringDriveRepository extends JpaRepository<HiringDriveEntity, Long> {

    Optional<HiringDriveEntity> findByUniqueId(UUID uniqueId);
    boolean existsByUniqueId(UUID uniqueId);
    void deleteByUniqueId(UUID uniqueId);
    List<HiringDriveEntity> findByStatus(String status);
    List<HiringDriveEntity> findByFeaturedTrue();
    List<HiringDriveEntity> findByCompanyNameContainingIgnoreCase(String companyName);
    List<HiringDriveEntity> findByJobRoleContainingIgnoreCase(String jobRole);
}