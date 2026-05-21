package com.mark43.userdashboard.user.controller.userprofile;

import com.mark43.userdashboard.user.dto.userprofile.UserProfileDto;
import com.mark43.userdashboard.user.service.userprofile.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.mark43.utils.constant.AppConstant.API_VERSION;

@RequiredArgsConstructor
@RequestMapping(API_VERSION+"user-profile")
@RestController
public class UserProfileController {
    private final UserProfileService userProfileService;
    @PostMapping
    public ResponseEntity<?> create(UserProfileDto dto){
        return this.userProfileService.create(dto);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") UUID id, UserProfileDto dto){return this.userProfileService.update(id,dto);}
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id){return this.userProfileService.delete(id);}
}
