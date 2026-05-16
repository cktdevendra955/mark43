package com.mark43.user.controller.userlanguage;

import com.mark43.user.dto.language.UserLanguageDto;
import com.mark43.user.service.userlanguage.UserLanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.mark43.utils.constant.AppConstant.API_VERSION;

@RequestMapping(API_VERSION+"userLanguage/")
@RestController
@RequiredArgsConstructor
public class UserLanguageController {
    private final UserLanguageService userLanguageService;
    @GetMapping
    public ResponseEntity<?> getAllByUser(){
        return this.userLanguageService.getAllByUser();
    }
    @PostMapping
    public ResponseEntity<?> create(UserLanguageDto dto){
        return this.userLanguageService.create(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id){return this.userLanguageService.delete(id);}

}
