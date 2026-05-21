package com.mark43.userdashboard.jobs.service;

import com.mark43.common.service.customquery.CustomQueryServiceImpl;
import com.mark43.utils.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService{

    private final CustomQueryServiceImpl customQueryService;

    @Override
    public ResponseEntity<?> getAllOrderBy(Map<String, Object> params) {
        List<Map<String, Object>> list = customQueryService.fetchAllWithLimit("", "", "", "", null);
        List<Map<String, Object>> data_array = new LinkedList<>();
        return ResponseUtils.success(ResponseUtils.SUCCESS,data_array);
    }

    @Override
    public ResponseEntity<?> getByUniqueId(UUID uniqueId) {
        Map<String, Object> list = customQueryService.fetchSingleEntry("", "", "", "");
        Map<String, Object> data = new HashMap<>();
        return ResponseUtils.success(ResponseUtils.SUCCESS,data);
    }
}
