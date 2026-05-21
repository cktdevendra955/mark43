package com.mark43.userdashboard.user.controller.certification;

import com.mark43.userdashboard.user.dto.certification.CertificationDto;
import com.mark43.userdashboard.user.service.certification.CertificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/user/certification/")
@RequiredArgsConstructor
public class CertificationController {

    private final CertificationService certificationService;

    @GetMapping
    public ResponseEntity<?> getAllByUser(){
        return this.certificationService.getAllByUser();
    }
    @PostMapping
    public ResponseEntity<?> create(CertificationDto dto){
        return this.certificationService.create(dto);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") UUID id,CertificationDto dto){
        return this.certificationService.update(id,dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id){
        return this.certificationService.delete(id);
    }


}
