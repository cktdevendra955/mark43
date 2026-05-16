package com.mark43.user.repo;


import com.mark43.user.entity.CertificationEntity;
import com.mark43.user.entity.SocialLinkEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SocialLinkRepository extends JpaRepository<SocialLinkEntity, Long> {
    List<SocialLinkEntity> findByProfileId(Long profileId);
    Optional<SocialLinkEntity> findByUniqueId(UUID uniqueId);


    @Modifying
    @Transactional
    @Query(" DELETE FROM SocialLinkEntity e WHERE e.uniqueId = :uniqueId ")
    int hardDeleteByUniqueId(@Param("uniqueId") UUID uniqueId);
}
