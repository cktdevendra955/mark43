package com.mark43.userdashboard.user.service.project;


import com.mark43.userdashboard.user.dto.project.ProjectDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ProjectService {


    ResponseEntity<?> create(ProjectDto dto);
    ResponseEntity<?> update(UUID uniqueId, ProjectDto dto);
    ResponseEntity<?> getAllByUser();
    ResponseEntity<?> delete(UUID uniqueId);
}
