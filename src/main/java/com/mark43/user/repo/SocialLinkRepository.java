package com.mark43.user.repo;


import com.mark43.user.entity.SocialLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocialLinkRepository extends JpaRepository<SocialLinkEntity, Long> {
    List<SocialLinkEntity> findByProfileId(Long profileId);
}
