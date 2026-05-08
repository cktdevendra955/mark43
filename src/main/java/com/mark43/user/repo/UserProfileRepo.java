package com.mark43.user.repo;

import com.mark43.auth.entity.user.UserEntity;
import com.mark43.user.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepo extends JpaRepository<UserProfileEntity, Long> {

    Optional<UserProfileEntity> findByUser(UserEntity user);

    Optional<UserProfileEntity> findByUserId(Long userId);


}
