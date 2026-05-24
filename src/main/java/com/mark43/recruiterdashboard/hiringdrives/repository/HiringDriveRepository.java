package com.mark43.recruiterdashboard.hiringdrives.repository;

import com.mark43.recruiterdashboard.hiringdrives.entity.HiringDriveEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
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

    @Modifying
    @Transactional
    @Query("UPDATE HiringDriveEntity e SET e.deletedAt = :deletedAt, e.deletedBy = :deletedBy WHERE e.uniqueId = :uniqueId AND e.deletedAt IS NULL")
    int softDeleteByUniqueId(@Param("uniqueId") UUID uniqueId, @Param("deletedAt") OffsetDateTime deletedAt, @Param("deletedBy") Long deletedBy);
}