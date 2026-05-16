package com.mark43.user.service.project;


import com.mark43.user.dto.project.ProjectDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ProjectService {


    ResponseEntity<?> create(ProjectDto dto);
    ResponseEntity<?> update(UUID uniqueId, ProjectDto dto);
    ResponseEntity<?> getAllByUser();
    ResponseEntity<?> delete(UUID uniqueId);
}
