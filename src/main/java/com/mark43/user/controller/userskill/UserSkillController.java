package com.mark43.user.controller.userskill;

import com.mark43.user.dto.language.UserLanguageDto;
import com.mark43.user.dto.skill.UserSkillDto;
import com.mark43.user.service.skill.UserSkillService;
import com.mark43.user.service.userlanguage.UserLanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.mark43.utils.constant.AppConstant.API_VERSION;

@RestController
@RequestMapping(API_VERSION+"User-skill")
@RequiredArgsConstructor
public class UserSkillController {
    private final UserSkillService UserSkillService;
    @GetMapping
    public ResponseEntity<?> getAllByUser(){
        return this.UserSkillService.getAllByUser();
    }
    @PostMapping
    public ResponseEntity<?> create(UserSkillDto dto){
        return this.UserSkillService.create(dto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id){return this.UserSkillService.delete(id);}
}
