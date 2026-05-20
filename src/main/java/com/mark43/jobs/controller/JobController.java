package com.mark43.jobs.controller;

import com.mark43.jobs.service.JobService;
import com.mark43.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

import static com.mark43.utils.constant.AppConstant.API_VERSION;

@RestController
@RequestMapping(API_VERSION+"jobs/")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;
    @GetMapping
    public ResponseEntity<?> getAllOrderBy(@RequestParam Map<String, Object> params) {
        return jobService.getAllOrderBy(params);
    }

    @GetMapping("{uniqueId}")
    public ResponseEntity<?> getByUniqueId(@PathVariable UUID uniqueId) {
        return jobService.getByUniqueId(uniqueId);
    }
}
