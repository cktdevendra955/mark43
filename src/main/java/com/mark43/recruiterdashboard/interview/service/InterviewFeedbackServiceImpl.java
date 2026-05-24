package com.mark43.recruiterdashboard.interview.service;

import com.mark43.auth.utils.AuthUtil;
import com.mark43.exception.custom.ResourceNotFoundException;
import com.mark43.recruiterdashboard.interview.dto.InterviewFeedbackDto;
import com.mark43.recruiterdashboard.interview.entity.InterviewFeedbackEntity;
import com.mark43.recruiterdashboard.interview.repository.InterviewFeedbackRepository;
import com.mark43.utils.datetimeutil.DateTimeUtil;
import com.mark43.utils.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class InterviewFeedbackServiceImpl implements InterviewFeedbackService{

    private final InterviewFeedbackRepository interviewFeedbackRepository;


    @Override
    public ResponseEntity<?> create(InterviewFeedbackDto dto) {
        InterviewFeedbackEntity feedback = new InterviewFeedbackEntity();
        feedback.setTechnicalFeedback(dto.getTechnicalFeedback());
        feedback.setHrFeedback(dto.getHrFeedback());
        feedback.setRating(dto.getRating());
        feedback.setRecommendation(dto.getRecommendation());
        interviewFeedbackRepository.save(feedback);
        return ResponseUtils.created(ResponseUtils.CREATED_SUCCESSFULLY,feedback);
    }



    @Override
    public ResponseEntity<?> update(UUID uniqueId, InterviewFeedbackDto dto) {
        InterviewFeedbackEntity feedback = interviewFeedbackRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        feedback.setTechnicalFeedback(dto.getTechnicalFeedback());
        feedback.setHrFeedback(dto.getHrFeedback());
        feedback.setRating(dto.getRating());
        feedback.setRecommendation(dto.getRecommendation());
        interviewFeedbackRepository.save(feedback);
        return ResponseUtils.success(ResponseUtils.UPDATED_SUCCESSFULLY,feedback);
    }


    @Override
    public ResponseEntity<?> getByUniqueId(UUID uniqueId) {
        InterviewFeedbackEntity feedback = interviewFeedbackRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        return ResponseUtils.success(ResponseUtils.SUCCESS,feedback);

    }

    @Override
    public ResponseEntity<?> getAll(Map<String, Object> params) {
        Map<String ,Object> response = new HashMap<>();
        List<Map<String ,Object>> data_array= new LinkedList<>();
        response.put(ResponseUtils.KEY_DATA_ARRAY,data_array);
        return ResponseUtils.success(ResponseUtils.SUCCESS,response);
    }
    @Override
    public ResponseEntity<?> delete(UUID uniqueId) {
        int rows = this.interviewFeedbackRepository.softDeleteByUniqueId(uniqueId, DateTimeUtil.currentUtcDateTime(), AuthUtil.getUserId());
        if(rows > 0)return ResponseUtils.success(ResponseUtils.SUCCESS,null);
        return ResponseUtils.notFound(ResponseUtils.RECORD_NOT_FOUND);
    }
}
