package com.mark43.user.repo;


import com.mark43.user.entity.CertificationEntity;
import com.mark43.user.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

    List<ProjectEntity> findByProfileId(Long profileId);
    Optional<ProjectEntity> findByUniqueId(UUID uniqueId);
}