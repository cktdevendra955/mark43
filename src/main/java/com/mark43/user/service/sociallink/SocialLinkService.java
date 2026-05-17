package com.mark43.user.service.sociallink;


import com.mark43.user.dto.project.ProjectDto;
import com.mark43.user.dto.sociallink.SocialLinkDto;
import com.mark43.user.entity.SocialLinkEntity;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface SocialLinkService {
    ResponseEntity<?> create(SocialLinkDto dto);
    ResponseEntity<?> delete(UUID uniqueId);
}