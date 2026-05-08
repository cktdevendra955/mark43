package com.mark43.user.repo;

import com.mark43.user.entity.ResumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResumeRepository extends JpaRepository<ResumeEntity, Long> {

    List<ResumeEntity> findByProfileId(Long profileId);

    Optional<ResumeEntity> findByProfileIdAndPrimaryResumeTrue(Long profileId);
}