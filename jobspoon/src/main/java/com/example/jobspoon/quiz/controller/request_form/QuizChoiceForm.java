package com.example.jobspoon.quiz.controller.request_form;

import com.example.jobspoon.quiz.service.request.SubmitAnswerRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class QuizChoiceForm {

    private Long questionId;
    private int choiceNumber;
    private String choiceText;

    public SubmitAnswerRequest toCheckAnswer() {
        return new SubmitAnswerRequest(questionId, choiceNumber, choiceText);
    }

}
