package com.mark43.user.service.language;

import com.mark43.auth.utils.AuthUtil;
import com.mark43.user.dto.language.UserLanguageDto;
import com.mark43.user.dto.language.UserLanguageResponseDto;
import com.mark43.user.entity.UserLanguageEntity;
import com.mark43.user.repo.UserLanguageRepository;
import com.mark43.utils.collectionutil.CollectionUtil;
import com.mark43.utils.datetimeutil.DateTimeUtil;
import com.mark43.utils.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserLanguageServiceImp implements UserLanguageService{
    private final UserLanguageRepository userLanguageRepository;

    @Override
    public ResponseEntity<?> create(UserLanguageDto dto) {
        UserLanguageEntity entity = new  UserLanguageEntity();
        entity.setLanguageId(dto.getLanguageId());
        entity.setProfileId(dto.getProfileId());
        entity.setProficiencyLevel(dto.getProficiencyLevel());
        entity.setCreatedAt(DateTimeUtil.currentUtcDateTime());
        entity.setCreatedBy(AuthUtil.getUserProfileId());
        userLanguageRepository.save(entity);
        return ResponseUtils.created(ResponseUtils.CREATED_SUCCESSFULLY,null);
    }


    @Override
    public ResponseEntity<?> getAllByUser() {
        Map<String, Object> response = new HashMap<>();
        List<UserLanguageResponseDto> data_array = new LinkedList<>();
        List<UserLanguageEntity> dataList = this.userLanguageRepository.findByProfileId(AuthUtil.getUserProfileId());
        if (CollectionUtil.isNotEmpty(dataList)){
            for (UserLanguageEntity entity :dataList){
                UserLanguageResponseDto responseDto = new UserLanguageResponseDto();
                responseDto.setLanguageId(entity.getLanguageId());
                responseDto.setProfileId(entity.getProfileId());
                responseDto.setProficiencyLevel(entity.getProficiencyLevel());
                userLanguageRepository.save(entity);
                data_array.add(responseDto);
            }
        }
        response.put(ResponseUtils.KEY_DATA_ARRAY,data_array);
        return ResponseUtils.success(ResponseUtils.SUCCESS,response);
    }

    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {
        int rows = this.userLanguageRepository.hardDeleteByUniqueId(uniqueId);
        if(rows > 0)return ResponseUtils.success(ResponseUtils.SUCCESS,null);
        return ResponseUtils.notFound(ResponseUtils.RECORD_NOT_FOUND);
    }
}
