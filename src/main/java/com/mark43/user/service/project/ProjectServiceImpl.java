package com.mark43.user.service.project;

import com.mark43.user.dto.ProjectDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Override
    public ResponseEntity<?> create(ProjectDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(String id, ProjectDto dto) {
        return null;
    }

    @Override
    public Map<String, Object> getByProfileId(String profileId) {
        return Map.of();
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        return null;
    }
}
