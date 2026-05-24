package com.mark43.recruiterdashboard.hiringdrives.controller;

import com.mark43.recruiterdashboard.company.dto.CompanyDto;
import com.mark43.recruiterdashboard.hiringdrives.dto.HiringDriveDto;
import com.mark43.recruiterdashboard.hiringdrives.service.HiringDriveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

import static com.mark43.utils.constant.AppConstant.API_RECRUITER;

@RequestMapping(API_RECRUITER+"hiring-drive/")
@RequiredArgsConstructor
public class HiringDriveController {

    private final HiringDriveService hiringDriveService;


    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam Map<String,Object> params){
        return this.hiringDriveService.getAll(params);
    }

    @PostMapping
    public ResponseEntity<?> create(HiringDriveDto dto){
        return this.hiringDriveService.create(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getByUniqueId(@PathVariable(name = "id") UUID id){
        return this.hiringDriveService.getByUniqueId(id);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") UUID id, HiringDriveDto dto){
        return this.hiringDriveService.update(id,dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id){
        return this.hiringDriveService.delete(id);
    }


}
