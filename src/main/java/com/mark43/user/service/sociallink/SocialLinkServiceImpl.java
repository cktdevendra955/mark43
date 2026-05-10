package com.mark43.user.service.sociallink;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SocialLinkServiceImpl implements SocialLinkService{

    @Override
    public ResponseEntity<?> create(Map<String, Object> dto) {
        return null;
    }

    @Override
    public Map<String, Object> getByProfileId(String profileId) {
        return Map.of();
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }
}
