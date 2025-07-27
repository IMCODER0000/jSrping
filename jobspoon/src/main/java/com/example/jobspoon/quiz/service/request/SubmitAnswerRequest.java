package com.example.jobspoon.quiz.service.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class SubmitAnswerRequest {
    private Long questionId;
    private int choiceNumber;
    private String choiceText;


}
