package com.mark43.recruiterdashboard.company.controller;

import com.mark43.recruiterdashboard.company.dto.CompanyDto;
import com.mark43.recruiterdashboard.company.service.CompanyService;
import com.mark43.userdashboard.user.dto.certification.CertificationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

import static com.mark43.utils.constant.AppConstant.API_RECRUITER;

@RequestMapping(API_RECRUITER+"company/")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam Map<String,Object> params){
        return this.companyService.getAll(params);
    }
    @PostMapping
    public ResponseEntity<?> create(CompanyDto dto){
        return this.companyService.create(dto);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") UUID id, CompanyDto dto){
        return this.companyService.update(id,dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id){
        return this.companyService.delete(id);
    }

}
