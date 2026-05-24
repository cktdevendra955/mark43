package com.mark43.recruiterdashboard.jobs.controller;

import com.mark43.recruiterdashboard.interview.dto.InterviewDto;
import com.mark43.recruiterdashboard.interview.service.InterviewService;
import com.mark43.recruiterdashboard.jobs.dto.ApplicationStatusHistoryDto;
import com.mark43.recruiterdashboard.jobs.dto.JobApplicationDto;
import com.mark43.recruiterdashboard.jobs.dto.JobsDto;
import com.mark43.recruiterdashboard.jobs.service.JobsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

import static com.mark43.utils.constant.AppConstant.API_RECRUITER;

@RequestMapping(API_RECRUITER+"job/")
@RequiredArgsConstructor
public class JobController {
    private final JobsService jobsService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam Map<String,Object> params){
        return this.jobsService.getAll(params);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody JobsDto dto){
        return this.jobsService.create(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getByUniqueId(@PathVariable(name = "id") UUID id){
        return this.jobsService.getByUniqueId(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") UUID id,@RequestBody JobsDto dto){
        return this.jobsService.update(id,dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id){
        return this.jobsService.delete(id);
    }

    @PutMapping("change-status/{id}")
    public ResponseEntity<?> changeStatus(@PathVariable(name = "id") UUID id,@RequestParam String status){
        return this.jobsService.changeStatus(id,status);
    }

    @GetMapping("featured")
    public ResponseEntity<?> getFeatured(){
        return this.jobsService.getFeatured();
    }

    @GetMapping("urgent-hiring")
    public ResponseEntity<?> getUrgentHiring(){
        return this.jobsService.getUrgentHiring();
    }

    @GetMapping("active")
    public ResponseEntity<?> getActiveJobs(){
        return this.jobsService.getActiveJobs();
    }

    @GetMapping("search")
    public ResponseEntity<?> search(@RequestParam String keyword){
        return this.jobsService.search(keyword);
    }

    //** JOB APPLICATION **/

    @PostMapping("application")
    public ResponseEntity<?> jobApplicationCreate(@RequestBody JobApplicationDto dto){
        return this.jobsService.jobApplicationCreate(dto);
    }

    @PutMapping("application/{id}")
    public ResponseEntity<?> jobApplicationUpdate(@PathVariable(name = "id") UUID id,@RequestBody JobApplicationDto dto){
        return this.jobsService.jobApplicationUpdate(id,dto);
    }

    @GetMapping("application")
    public ResponseEntity<?> jobApplicationGetAll(@RequestParam Map<String,Object> params){
        return this.jobsService.jobApplicationGetAll(params);
    }

    @GetMapping("application/{id}")
    public ResponseEntity<?> jobApplicationGetByUniqueId(@PathVariable(name = "id") UUID id){
        return this.jobsService.jobApplicationGetByUniqueId(id);
    }

    @DeleteMapping("application/{id}")
    public ResponseEntity<?> jobApplicationDelete(@PathVariable(name = "id") UUID id){
        return this.jobsService.jobApplicationDelete(id);
    }

    @PutMapping("application/change-status/{id}")
    public ResponseEntity<?> jobApplicationChangeStatus(@PathVariable(name = "id") UUID id,@RequestParam String status){
        return this.jobsService.jobApplicationChangeStatus(id,status);
    }

    //** JOB APPLICATION HISTORY **/

    @PostMapping("application-history")
    public ResponseEntity<?> applicationStatusHistoryCreate(@RequestBody ApplicationStatusHistoryDto dto){
        return this.jobsService.applicationStatusHistoryCreate(dto);
    }

    @PutMapping("application-history/{id}")
    public ResponseEntity<?> applicationStatusHistoryUpdate(@PathVariable(name = "id") UUID id,@RequestBody ApplicationStatusHistoryDto dto){
        return this.jobsService.applicationStatusHistoryUpdate(id,dto);
    }

    @GetMapping("application-history")
    public ResponseEntity<?> applicationStatusHistoryGetAll(@RequestParam Map<String,Object> params){
        return this.jobsService.applicationStatusHistoryGetAll(params);
    }

    @GetMapping("application-history/{id}")
    public ResponseEntity<?> applicationStatusHistoryGetByUniqueId(@PathVariable(name = "id") UUID id){
        return this.jobsService.applicationStatusHistoryGetByUniqueId(id);
    }

    @DeleteMapping("application-history/{id}")
    public ResponseEntity<?> applicationStatusHistoryDelete(@PathVariable(name = "id") UUID id){
        return this.jobsService.applicationStatusHistoryDelete(id);
    }
}
