package com.mark43.userdashboard.user.repo;

import com.mark43.userdashboard.user.entity.CertificationEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CertificationRepository extends JpaRepository<CertificationEntity, Long> {

    List<CertificationEntity> findByProfileId(Long profileId);
    Optional<CertificationEntity> findByUniqueId(UUID uniqueId);

    @Modifying
    @Transactional
    @Query("UPDATE CertificationEntity c SET c.deletedAt = :deletedAt, c.deletedBy = :deletedBy WHERE c.uniqueId = :uniqueId AND c.deletedAt IS NULL")
    int softDeleteByUniqueId(@Param("uniqueId") UUID uniqueId,@Param("deletedAt") OffsetDateTime deletedAt,@Param("deletedBy") Long deletedBy);
}