package com.mark43.recruiterdashboard.interview.repository;

import com.mark43.recruiterdashboard.interview.entity.InterviewFeedbackEntity;
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
public interface InterviewFeedbackRepository extends JpaRepository<InterviewFeedbackEntity, Long> {

    Optional<InterviewFeedbackEntity> findByUniqueId(UUID uniqueId);
    boolean existsByUniqueId(UUID uniqueId);
    void deleteByUniqueId(UUID uniqueId);

    @Modifying
    @Transactional
    @Query("UPDATE InterviewFeedbackEntity e SET e.deletedAt = :deletedAt, e.deletedBy = :deletedBy WHERE e.uniqueId = :uniqueId AND e.deletedAt IS NULL")
    int softDeleteByUniqueId(@Param("uniqueId") UUID uniqueId, @Param("deletedAt") OffsetDateTime deletedAt, @Param("deletedBy") Long deletedBy);
}
