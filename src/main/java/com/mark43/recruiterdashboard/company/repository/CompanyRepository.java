package com.mark43.recruiterdashboard.company.repository;

import com.mark43.recruiterdashboard.company.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
    Optional<CompanyEntity> findByUniqueId(UUID uniqueId);
    boolean existsByUniqueId(UUID uniqueId);
    void deleteByUniqueId(UUID uniqueId);
    Optional<CompanyEntity> findByEmail(String email);
    Optional<CompanyEntity> findByWebsite(String website);
}