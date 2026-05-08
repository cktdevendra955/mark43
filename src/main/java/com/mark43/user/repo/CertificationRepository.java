package com.mark43.user.repo;

import com.mark43.user.entity.CertificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificationRepository extends JpaRepository<CertificationEntity, Long> {

    List<CertificationEntity> findByProfileId(Long profileId);
}