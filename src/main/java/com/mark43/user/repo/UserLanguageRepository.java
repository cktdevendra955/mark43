package com.mark43.user.repo;

import com.mark43.user.entity.UserLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserLanguageRepository extends JpaRepository<UserLanguageEntity, Long> {

    List<UserLanguageEntity> findByProfileId(Long profileId);
}