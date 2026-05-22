package com.mark43.recruiterdashboard.recruiter.repository;
import com.mark43.recruiterdashboard.recruiter.entity.RecruiterProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RecruiterProfileRepository extends JpaRepository<RecruiterProfileEntity, Long> {
    Optional<RecruiterProfileEntity> findByUniqueId(UUID uniqueId);
    boolean existsByUniqueId(UUID uniqueId);
    void deleteByUniqueId(UUID uniqueId);
}