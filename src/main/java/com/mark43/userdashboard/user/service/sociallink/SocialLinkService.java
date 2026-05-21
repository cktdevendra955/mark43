package com.mark43.userdashboard.user.service.sociallink;


import com.mark43.userdashboard.user.dto.sociallink.SocialLinkDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface SocialLinkService {
    ResponseEntity<?> create(SocialLinkDto dto);
    ResponseEntity<?> delete(UUID uniqueId);
}