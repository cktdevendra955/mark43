package com.mark43.common.repo.hiringdrives;

import com.mark43.common.entity.hiringdrives.HiringDriveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HiringDriveRepository extends JpaRepository<HiringDriveEntity,Long> {
}
