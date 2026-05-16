package com.mark43.user.repo;

import com.mark43.user.entity.CertificationEntity;
import com.mark43.user.entity.ExperienceEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Long> {

    List<ExperienceEntity> findByProfileId(Long profileId);

    Optional<ExperienceEntity> findByUniqueId(UUID uniqueId);

    @Modifying
    @Transactional
    @Query("UPDATE ExperienceEntity ex SET ex.deletedAt = :deletedAt, ex.deletedBy = :deletedBy WHERE ex.uniqueId = :uniqueId AND ex.deletedAt IS NULL")
    int softDeleteByUniqueId(@Param("uniqueId") UUID uniqueId, @Param("deletedAt") OffsetDateTime deletedAt, @Param("deletedBy") Long deletedBy);
}