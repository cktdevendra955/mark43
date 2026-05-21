package com.mark43.common.repo.jobs;

import com.mark43.common.entity.jobs.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface JobsRepository
        extends JpaRepository<JobsEntity, Long> {

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
}