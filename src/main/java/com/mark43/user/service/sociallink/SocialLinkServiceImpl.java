package com.mark43.user.service.sociallink;

import com.mark43.user.dto.project.ProjectDto;
import com.mark43.user.dto.sociallink.SocialLinkDto;
import com.mark43.user.entity.SocialLinkEntity;
import com.mark43.user.repo.SocialLinkRepository;
import com.mark43.utils.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SocialLinkServiceImpl implements SocialLinkService{

    private final SocialLinkRepository socialLinkRepository;

    @Override
    public ResponseEntity<?> create(SocialLinkDto dto) {
        SocialLinkEntity entity = new SocialLinkEntity();
        entity.setPlatform(dto.getPlatform());
        entity.setUrl(dto.getUrl());
        socialLinkRepository.save(entity);
        return ResponseUtils.success(ResponseUtils.SUCCESS,null);
    }

    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {
        int rows = this.socialLinkRepository.hardDeleteByUniqueId(uniqueId);
        if(rows > 0)return ResponseUtils.success(ResponseUtils.SUCCESS,null);
        return ResponseUtils.notFound(ResponseUtils.RECORD_NOT_FOUND);
    }
}
