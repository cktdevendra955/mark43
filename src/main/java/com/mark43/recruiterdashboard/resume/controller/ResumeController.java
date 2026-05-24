package com.mark43.recruiterdashboard.resume.controller;


import com.mark43.recruiterdashboard.resume.dto.ResumeDto;
import com.mark43.recruiterdashboard.resume.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

import static com.mark43.utils.constant.AppConstant.API_RECRUITER;

@RestController
@RequestMapping(API_RECRUITER+"resume/")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ResumeDto dto){
        return this.resumeService.create(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") UUID id, @RequestBody ResumeDto dto){
        return this.resumeService.update(id,dto);
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam Map<String,Object> params){
        return this.resumeService.getAll(params);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getByUniqueId(@PathVariable(name = "id") UUID id){
        return this.resumeService.getByUniqueId(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id){
        return this.resumeService.delete(id);
    }
}