package com.mark43.auth.repo.user;

import com.mark43.auth.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Long> {
}