package com.mark43.recruiterdashboard.jobs.repository;

import com.mark43.recruiterdashboard.jobs.entity.JobsEntity;
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
public interface JobsRepository extends JpaRepository<JobsEntity, Long> {
    Optional<JobsEntity> findByUniqueId(UUID uniqueId);
    boolean existsByUniqueId(UUID uniqueId);
    void deleteByUniqueId(UUID uniqueId);
    List<JobsEntity> findByStatus(String status);
    List<JobsEntity> findByFeaturedTrue();
    List<JobsEntity> findByUrgentHiringTrue();
    List<JobsEntity> findByActiveTrue();
    List<JobsEntity> findByTitleContainingIgnoreCase(String title);
    List<JobsEntity> findByCompanyNameContainingIgnoreCase(String companyName);
    List<JobsEntity> findByLocationContainingIgnoreCase(String location);
    List<JobsEntity> findByJobTypeContainingIgnoreCase(String jobType);
    List<JobsEntity> findByWorkModeContainingIgnoreCase(String workMode);


    @Modifying
    @Transactional
    @Query("UPDATE JobsEntity e SET e.deletedAt = :deletedAt, e.deletedBy = :deletedBy WHERE e.uniqueId = :uniqueId AND e.deletedAt IS NULL")
    int softDeleteByUniqueId(@Param("uniqueId") UUID uniqueId, @Param("deletedAt") OffsetDateTime deletedAt, @Param("deletedBy") Long deletedBy);



}