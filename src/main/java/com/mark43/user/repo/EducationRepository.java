package com.mark43.user.repo;

import com.mark43.user.entity.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<EducationEntity, Long> {
    List<EducationEntity> findByProfileId(Long profileId);
}
