package com.mark43.recruiterdashboard.recruiter.controller;

import com.mark43.recruiterdashboard.recruiter.dto.RecruiterProfileDto;
import com.mark43.recruiterdashboard.recruiter.service.RecruiterProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

import static com.mark43.utils.constant.AppConstant.API_RECRUITER;

@RestController
@RequestMapping(API_RECRUITER+"recruiter-profile/")
@RequiredArgsConstructor
public class RecruiterProfileController {

    private final RecruiterProfileService recruiterProfileService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody RecruiterProfileDto dto){
        return this.recruiterProfileService.create(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") UUID id, @RequestBody RecruiterProfileDto dto){
        return this.recruiterProfileService.update(id,dto);
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam Map<String,Object> params){
        return this.recruiterProfileService.getAll(params);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getByUniqueId(@PathVariable(name = "id") UUID id){
        return this.recruiterProfileService.getByUniqueId(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id){
        return this.recruiterProfileService.delete(id);
    }
}