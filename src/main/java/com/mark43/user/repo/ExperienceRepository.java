package com.mark43.user.repo;

import com.mark43.user.entity.ExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Long> {

    List<ExperienceEntity> findByProfileId(Long profileId);
}