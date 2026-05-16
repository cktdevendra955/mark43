package com.mark43.user.repo;

import com.mark43.user.entity.CertificationEntity;
import com.mark43.user.entity.UserLanguageEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserLanguageRepository extends JpaRepository<UserLanguageEntity, Long> {

    List<UserLanguageEntity> findByProfileId(Long profileId);
    Optional<UserLanguageEntity> findByUniqueId(UUID uniqueId);

    @Modifying
    @Transactional
    @Query(" DELETE FROM UserLanguageEntity e WHERE e.uniqueId = :uniqueId ")
    int hardDeleteByUniqueId(@Param("uniqueId") UUID uniqueId);

}