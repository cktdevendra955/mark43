package com.mark43.common.repo;

import com.mark43.common.entity.SkillEntity;
import com.mark43.user.entity.UserSkillEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SkillRepository extends JpaRepository<UserSkillEntity, Long> {

    Optional<UserSkillEntity> findByNameIgnoreCase(String name);
    Boolean existsByNameIgnoreCase(String name);
    @Modifying
    @Transactional
    @Query(" DELETE FROM UserSkillEntity e WHERE e.uniqueId = :uniqueId ")
    int hardDeleteByUniqueId(@Param("uniqueId") UUID uniqueId);
}