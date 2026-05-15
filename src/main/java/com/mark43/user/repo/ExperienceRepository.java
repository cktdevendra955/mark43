package com.mark43.user.repo;

import com.mark43.user.entity.CertificationEntity;
import com.mark43.user.entity.ExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Long> {

    List<ExperienceEntity> findByProfileId(Long profileId);

    Optional<ExperienceEntity> findByUniqueId(UUID uniqueId);
}