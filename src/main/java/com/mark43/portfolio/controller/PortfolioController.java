package com.mark43.portfolio.controller;

import com.mark43.portfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

import static com.mark43.utils.constant.AppConstant.API_VERSION;

@RestController
@RequestMapping(API_VERSION+"portfolio/")
@RequiredArgsConstructor
public class PortfolioController {
    private final PortfolioService portfolioService;

    @GetMapping
    public ResponseEntity<?> getAllOrderBy(@RequestParam Map<String, Object> params) {
        return portfolioService.getAllOrderBy(params);
    }

    @GetMapping("{uniqueId}")
    public ResponseEntity<?> getByUniqueId(@PathVariable UUID uniqueId) {
        return portfolioService.getByUniqueId(uniqueId);
    }
}
