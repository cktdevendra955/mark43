package com.mark43.recruiterdashboard.company.repository;

import com.mark43.recruiterdashboard.company.entity.CompanyEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
    Optional<CompanyEntity> findByUniqueId(UUID uniqueId);
    boolean existsByUniqueId(UUID uniqueId);
    void deleteByUniqueId(UUID uniqueId);
    Optional<CompanyEntity> findByEmail(String email);
    Optional<CompanyEntity> findByWebsite(String website);

    @Modifying
    @Transactional
    @Query("UPDATE CompanyEntity c SET c.deletedAt = :deletedAt, c.deletedBy = :deletedBy WHERE c.uniqueId = :uniqueId AND c.deletedAt IS NULL")
    int softDeleteByUniqueId(@Param("uniqueId") UUID uniqueId, @Param("deletedAt") OffsetDateTime deletedAt, @Param("deletedBy") Long deletedBy);
}