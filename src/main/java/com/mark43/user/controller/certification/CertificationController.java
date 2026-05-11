package com.mark43.user.controller.certification;

import com.mark43.user.dto.CertificationDto;
import com.mark43.user.service.certification.CertificationService;
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

    @PutMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id){
        return this.certificationService.delete(id);
    }


}
