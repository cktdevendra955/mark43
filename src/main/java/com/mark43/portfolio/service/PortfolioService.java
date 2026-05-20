package com.mark43.portfolio.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface PortfolioService {
    ResponseEntity<?> getAllOrderBy(Map<String,Object> params);
    ResponseEntity<?> getByUniqueId(UUID uniqueId);
}
