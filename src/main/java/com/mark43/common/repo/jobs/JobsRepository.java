package com.mark43.common.repo.jobs;

import com.mark43.common.entity.jobs.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<JobsEntity,Long> {
}
