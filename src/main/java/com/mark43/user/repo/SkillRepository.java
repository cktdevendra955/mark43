package com.mark43.user.repo;

import com.mark43.user.entity.UserSkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<UserSkillEntity, Long> {

    Optional<UserSkillEntity> findByNameIgnoreCase(String name);

    Boolean existsByNameIgnoreCase(String name);
}