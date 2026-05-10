package com.mark43.user.service.sociallink;


import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface SocialLinkService {

    ResponseEntity<?> create(Map<String,Object> dto);

    Map<String,Object>  getByProfileId(String profileId);

    ResponseEntity<?> delete(Long id);
}