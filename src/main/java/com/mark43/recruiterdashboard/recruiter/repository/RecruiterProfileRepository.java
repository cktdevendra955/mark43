package com.mark43.recruiterdashboard.recruiter.repository;
import com.mark43.recruiterdashboard.recruiter.entity.RecruiterProfileEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RecruiterProfileRepository extends JpaRepository<RecruiterProfileEntity, Long> {
    Optional<RecruiterProfileEntity> findByUniqueId(UUID uniqueId);
    boolean existsByUniqueId(UUID uniqueId);
    void deleteByUniqueId(UUID uniqueId);


    @Modifying
    @Transactional
    @Query("UPDATE RecruiterProfileEntity e SET e.deletedAt = :deletedAt, e.deletedBy = :deletedBy WHERE e.uniqueId = :uniqueId AND e.deletedAt IS NULL")
    int softDeleteByUniqueId(@Param("uniqueId") UUID uniqueId, @Param("deletedAt") OffsetDateTime deletedAt, @Param("deletedBy") Long deletedBy);

}