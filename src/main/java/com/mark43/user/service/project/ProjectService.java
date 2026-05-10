package com.mark43.user.service.project;


import com.mark43.user.dto.ProjectDto;
import com.mark43.user.entity.ProjectEntity;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ProjectService {

    ResponseEntity<?> create(ProjectDto dto);

    ResponseEntity<?> update(String id, ProjectDto dto);

    Map<String,Object> getByProfileId(String profileId);

    ResponseEntity<?> delete(String id);
}
