package com.example.jobspoon.quiz.service.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuizAnswerResponse {
    private int choiceNumber;
    private String choiceText;
    private boolean isCorrect;
    private String explanation;
}
