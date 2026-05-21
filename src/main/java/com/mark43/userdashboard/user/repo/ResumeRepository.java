package com.mark43.userdashboard.user.repo;

import com.mark43.userdashboard.user.entity.ResumeEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ResumeRepository extends JpaRepository<ResumeEntity, Long> {

    Optional<ResumeEntity> findByProfileId(Long profileId);

    Optional<ResumeEntity> findByProfileIdAndPrimaryResumeTrue(Long profileId);
    Optional<ResumeEntity> findByUniqueId(UUID uniqueId);

    @Modifying
    @Transactional
    @Query(" DELETE FROM ResumeEntity e WHERE e.uniqueId = :uniqueId ")
    int hardDeleteByUniqueId(@Param("uniqueId") UUID uniqueId);

}