package com.mark43.userdashboard.user.controller.sociallink;


import com.mark43.userdashboard.user.dto.sociallink.SocialLinkDto;
import com.mark43.userdashboard.user.service.sociallink.SocialLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.mark43.utils.constant.AppConstant.API_VERSION;

@RestController
@RequestMapping(API_VERSION+"sociallink")
@RequiredArgsConstructor
public class SocialLinkController {
    private final SocialLinkService socialLinkService;

    @PostMapping
    public ResponseEntity<?> create(SocialLinkDto dto){
        return this.socialLinkService.create(dto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id){return this.socialLinkService.delete(id);}

}
