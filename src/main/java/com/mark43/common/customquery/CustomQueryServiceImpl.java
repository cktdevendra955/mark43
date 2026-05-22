package com.mark43.common.customquery;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CustomQueryServiceImpl {

    private final JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> fetchAll(String selectQuery,String whereCondition,String orderBy,String groupBy) {
        String query = appendQueryConditions(selectQuery,whereCondition,orderBy,groupBy,null);
        return jdbcTemplate.queryForList(query);
    }

    public List<Map<String, Object>> fetchAllWithLimit(String selectQuery,String whereCondition,String orderBy,String groupBy,Integer limit) {
        String query = appendQueryConditions(selectQuery,whereCondition,orderBy,groupBy,limit);
        return jdbcTemplate.queryForList(query);
    }

    public Map<String, Object> fetchSingleEntry(String selectQuery,String whereCondition,String orderBy,String groupBy) {
        String query = appendQueryConditions(selectQuery,whereCondition,orderBy,groupBy,1);
        return jdbcTemplate.queryForMap(query);
    }

    private String appendQueryConditions(String selectQuery,String whereCondition,String orderBy,String groupBy,Integer limit) {
        StringBuilder query = new StringBuilder(selectQuery);
        if (whereCondition != null && !whereCondition.isBlank()) {
            query.append(" WHERE ").append(whereCondition);
        }

        if (groupBy != null && !groupBy.isBlank()) {
            query.append(" GROUP BY ").append(groupBy);
        }

        if (orderBy != null && !orderBy.isBlank()) {
            query.append(" ORDER BY ").append(orderBy);
        }

        if (limit != null && limit > 0) {
            query.append(" LIMIT ").append(limit);
        }
        return query.toString();
    }
}