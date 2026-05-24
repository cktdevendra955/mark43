package com.mark43.recruiterdashboard.interview.controller;


import com.mark43.recruiterdashboard.hiringdrives.dto.HiringDriveDto;
import com.mark43.recruiterdashboard.hiringdrives.service.HiringDriveService;
import com.mark43.recruiterdashboard.interview.dto.InterviewDto;
import com.mark43.recruiterdashboard.interview.service.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

import static com.mark43.utils.constant.AppConstant.API_RECRUITER;

@RequestMapping(API_RECRUITER+"hiring-drive/")
@RequiredArgsConstructor
public class InterviewController {


    private final InterviewService interviewService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam Map<String,Object> params){
        return this.interviewService.getAll(params);
    }

    @PostMapping
    public ResponseEntity<?> create(InterviewDto dto){
        return this.interviewService.create(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getByUniqueId(@PathVariable(name = "id") UUID id){
        return this.interviewService.getByUniqueId(id);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") UUID id, InterviewDto dto){
        return this.interviewService.update(id,dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id){
        return this.interviewService.delete(id);
    }

}
