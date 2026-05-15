package com.mark43.user.repo;


import com.mark43.user.entity.CertificationEntity;
import com.mark43.user.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {
    Optional<LanguageEntity> findByNameIgnoreCase(String name);
    Boolean existsByNameIgnoreCase(String name);
    Optional<LanguageEntity> findByUniqueId(UUID uniqueId);
}
