package com.mark43.recruiterdashboard.recruiter.controller;


import com.mark43.recruiterdashboard.recruiter.dto.SavedCandidateDto;
import com.mark43.recruiterdashboard.recruiter.service.SavedCandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

import static com.mark43.utils.constant.AppConstant.API_RECRUITER;

@RestController
@RequestMapping(API_RECRUITER+"saved-candidate/")
@RequiredArgsConstructor
public class SavedCandidateController {

    private final SavedCandidateService savedCandidateService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SavedCandidateDto dto){
        return this.savedCandidateService.create(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") UUID id, @RequestBody SavedCandidateDto dto){
        return this.savedCandidateService.update(id,dto);
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam Map<String,Object> params){
        return this.savedCandidateService.getAll(params);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getByUniqueId(@PathVariable(name = "id") UUID id){
        return this.savedCandidateService.getByUniqueId(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id){
        return this.savedCandidateService.delete(id);
    }
}