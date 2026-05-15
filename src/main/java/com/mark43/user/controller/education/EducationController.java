package com.mark43.user.controller.education;

import com.mark43.user.dto.CertificationDto;
import com.mark43.user.dto.EducationDto;
import com.mark43.user.repo.EducationRepository;
import com.mark43.user.service.certification.CertificationService;
import com.mark43.user.service.education.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/education/")
@RequiredArgsConstructor
public class EducationController {
    private final EducationService educationService;

    @GetMapping
    public ResponseEntity<?> getAllByUser(){
        return this.educationService.getAllByUser();
    }
    @PostMapping
    public ResponseEntity<?> create(EducationDto dto){
        return this.educationService.create(dto);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") UUID id, EducationDto dto){
        return this.educationService.update(id,dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id){
        return this.educationService.delete(id);
    }
}
