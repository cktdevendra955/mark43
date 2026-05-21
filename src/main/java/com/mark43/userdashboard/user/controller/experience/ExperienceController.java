package com.mark43.userdashboard.user.controller.experience;

import com.mark43.userdashboard.user.dto.experience.ExperienceDto;
import com.mark43.userdashboard.user.service.experience.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/experience/")
@RequiredArgsConstructor
public class ExperienceController {
    private final ExperienceService experienceService;
    @GetMapping
    public ResponseEntity<?> getAllByUser(){
        return this.experienceService.getAllByUser();
    }
    @PostMapping
    public ResponseEntity<?> create(ExperienceDto dto){
        return this.experienceService.create(dto);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") UUID id, ExperienceDto dto){return this.experienceService.update(id,dto);}
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id){
        return this.experienceService.delete(id);
    }
}
