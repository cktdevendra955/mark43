package com.mark43.user.repo;

import com.mark43.auth.entity.user.UserEntity;
import com.mark43.user.entity.SkillEntity;
import com.mark43.user.entity.UserSkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSkillRepository extends JpaRepository<UserSkillEntity, Long> {

    List<UserSkillEntity> findByUser(UserEntity user);

    List<UserSkillEntity> findByUserId(Long userId);

    Boolean existsByUserAndSkill(UserEntity user, SkillEntity skill);

    void deleteByUserId(Long userId);
    List<SkillEntity> findByNameContainingIgnoreCase(String keyword);

}