package com.mark43.recruiterdashboard.jobs.repository;

import com.mark43.recruiterdashboard.jobs.entity.ApplicationStatusHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApplicationStatusHistoryRepository extends JpaRepository<ApplicationStatusHistoryEntity, Long> {

    boolean existsByUniqueId(UUID uniqueId);
    void deleteByUniqueId(UUID uniqueId);
}
