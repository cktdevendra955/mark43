package com.mark43.user.repo;


import com.mark43.user.entity.CertificationEntity;
import com.mark43.user.entity.SocialLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SocialLinkRepository extends JpaRepository<SocialLinkEntity, Long> {
    List<SocialLinkEntity> findByProfileId(Long profileId);
    Optional<SocialLinkEntity> findByUniqueId(UUID uniqueId);

}
