package com.mark43.common.service.customquery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Transactional
@Slf4j
public class CustomQueryServiceImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Map<String, Object>> fetchAll(String selectQuery,String whereCondition,String orderBy,String groupBy) {
        String query = appendQueryConditions(selectQuery,whereCondition,orderBy,groupBy,null);
        Query nativeQuery = entityManager.createNativeQuery(query);
        nativeQuery.unwrap(NativeQuery.class).setTupleTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return nativeQuery.getResultList();
    }
    public List<Map<String, Object>> fetchAllWithLimit(String selectQuery,String whereCondition,String orderBy,String groupBy,Integer limit) {
        String query = appendQueryConditions(selectQuery,whereCondition,orderBy,groupBy,limit);
        Query nativeQuery =entityManager.createNativeQuery(query);
        nativeQuery.unwrap(NativeQuery.class).setTupleTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return nativeQuery.getResultList();
    }

    public Map<String, Object> fetchSingleEntry(String selectQuery,String whereCondition,String orderBy,String groupBy) {

        String query = appendQueryConditions(selectQuery,whereCondition,orderBy,groupBy,1);
        Query nativeQuery =entityManager.createNativeQuery(query);
        nativeQuery.unwrap(NativeQuery.class).setTupleTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return (Map<String, Object>)nativeQuery.getSingleResult();
    }


    private String appendQueryConditions(String selectQuery,String whereCondition,String orderBy,String groupBy,Integer limit) {

        StringBuilder query = new StringBuilder(selectQuery);
        if (whereCondition != null && !whereCondition.isBlank()) {
            query.append(" WHERE ") .append(whereCondition);
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