package com.example.jobspoon.quiz.controller.response_form;

import com.example.jobspoon.quiz.service.response.QuizAnswerResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SubmitAnswerResponseForm {
    private int selectedIndex;
    private String answerText;
    private boolean isCorrect;
    private String explanation;


    public static SubmitAnswerResponseForm from(QuizAnswerResponse response) {
        return new SubmitAnswerResponseForm(
                response.getChoiceNumber(),
                response.getChoiceText(),
                response.isCorrect(),
                response.getExplanation()
        );
    }
}
