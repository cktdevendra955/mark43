package com.mark43.recruiterdashboard.interview.service;

import com.mark43.auth.utils.AuthUtil;
import com.mark43.exception.custom.ResourceNotFoundException;
import com.mark43.recruiterdashboard.interview.dto.InterviewDto;
import com.mark43.recruiterdashboard.interview.entity.InterviewEntity;
import com.mark43.recruiterdashboard.interview.repository.InterviewRepository;
import com.mark43.utils.datetimeutil.DateTimeUtil;
import com.mark43.utils.response.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class InterviewServiceImpl implements InterviewService{
    private final InterviewRepository interviewRepository;

    @Override
    public ResponseEntity<?> create(InterviewDto dto) {
        InterviewEntity interview =new InterviewEntity();

        interview.setInterviewRound(dto.getInterviewRound());
        interview.setInterviewerName(dto.getInterviewerName());
        interview.setInterviewType(dto.getInterviewType());
        interview.setInterviewDateTime(dto.getInterviewDateTime());
        interview.setMeetingLink(dto.getMeetingLink());
        interview.setFeedback(dto.getFeedback());
        interview.setResult(dto.getResult());
        interview.setCompleted(dto.getCompleted());
        interviewRepository.save(interview);
        return ResponseUtils.created(ResponseUtils.CREATED_SUCCESSFULLY,null);
    }

    @Override
    public ResponseEntity<?> update(UUID uniqueId, InterviewDto dto) {
        InterviewEntity interview = interviewRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));interview.setInterviewRound(dto.getInterviewRound());
        interview.setInterviewerName(dto.getInterviewerName());
        interview.setInterviewType(dto.getInterviewType());
        interview.setInterviewDateTime(dto.getInterviewDateTime());
        interview.setMeetingLink(dto.getMeetingLink());
        interview.setFeedback(dto.getFeedback());
        interview.setResult(dto.getResult());
        interview.setCompleted(dto.getCompleted());
        interviewRepository.save(interview);
        return ResponseUtils.success(ResponseUtils.UPDATED_SUCCESSFULLY,null);
    }


    @Override
    public ResponseEntity<?> getByUniqueId(UUID uniqueId) {
        InterviewEntity interview = interviewRepository.findByUniqueId(uniqueId).orElseThrow(() -> new ResourceNotFoundException(ResponseUtils.RECORD_NOT_FOUND));
        return ResponseUtils.success(ResponseUtils.SUCCESS,interview);
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
        int rows = this.interviewRepository.softDeleteByUniqueId(uniqueId, DateTimeUtil.currentUtcDateTime(), AuthUtil.getUserId());
        if(rows > 0)return ResponseUtils.success(ResponseUtils.SUCCESS,null);
        return ResponseUtils.notFound(ResponseUtils.RECORD_NOT_FOUND);
    }
}
