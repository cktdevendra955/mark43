package com.mark43.userdashboard.drives.controller;


import com.mark43.userdashboard.drives.service.DrivesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

import static com.mark43.utils.constant.AppConstant.API_VERSION;

@RestController
@RequestMapping(API_VERSION+"drives/")
@RequiredArgsConstructor
public class DrivesController {

    private final DrivesService drivesService;

    @GetMapping
    public ResponseEntity<?> getAllOrderBy(@RequestParam Map<String, Object> params) {
        return drivesService.getAllOrderBy(params);
    }

    @GetMapping("{uniqueId}")
    public ResponseEntity<?> getByUniqueId(@PathVariable UUID uniqueId) {
        return drivesService.getByUniqueId(uniqueId);
    }
}
