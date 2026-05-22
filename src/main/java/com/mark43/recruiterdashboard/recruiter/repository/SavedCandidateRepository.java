package com.mark43.recruiterdashboard.recruiter.repository;


import com.mark43.recruiterdashboard.recruiter.entity.SavedCandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SavedCandidateRepository extends JpaRepository<SavedCandidateEntity, Long> {
    Optional<SavedCandidateEntity> findByUniqueId(UUID uniqueId);
    boolean existsByUniqueId(UUID uniqueId);
    void deleteByUniqueId(UUID uniqueId);
}
