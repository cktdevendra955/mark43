package com.mark43.recruiterdashboard.interview.repository;

import com.mark43.recruiterdashboard.interview.entity.InterviewFeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface InterviewFeedbackRepository extends JpaRepository<InterviewFeedbackEntity, Long> {

    Optional<InterviewFeedbackEntity> findByUniqueId(UUID uniqueId);
    boolean existsByUniqueId(UUID uniqueId);
    void deleteByUniqueId(UUID uniqueId);
}
