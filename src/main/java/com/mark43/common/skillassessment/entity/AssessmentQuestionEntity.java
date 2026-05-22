package com.mark43.common.skillassessment.entity;

import com.mark43.basefiles.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "assessment_questions")
public class AssessmentQuestionEntity extends BaseEntity {
    private Long assessmentId;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;
}