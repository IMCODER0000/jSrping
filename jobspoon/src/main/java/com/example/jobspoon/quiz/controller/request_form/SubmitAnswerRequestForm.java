package com.example.jobspoon.quiz.controller.request_form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class SubmitAnswerRequestForm {
    private Long questionId;
    private int selectedChoiceNumber;
}
