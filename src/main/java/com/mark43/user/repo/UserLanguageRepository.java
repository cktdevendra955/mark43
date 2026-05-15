package com.mark43.user.repo;

import com.mark43.user.entity.CertificationEntity;
import com.mark43.user.entity.UserLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserLanguageRepository extends JpaRepository<UserLanguageEntity, Long> {

    List<UserLanguageEntity> findByProfileId(Long profileId);
    Optional<UserLanguageEntity> findByUniqueId(UUID uniqueId);
}