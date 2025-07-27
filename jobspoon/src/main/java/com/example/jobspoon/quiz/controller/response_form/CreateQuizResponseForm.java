package com.example.jobspoon.quiz.controller.response_form;

import com.example.jobspoon.quiz.service.request.QuizAnswerRequest;
import com.example.jobspoon.quiz.service.response.CreateQuizResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class CreateQuizResponseForm {

//    Long quizSetId;         // QuizSet : 오늘의 랜덤 퀴즈 10문제, Front분야 OX 문제셋 등
//    Long termId;
    private Long questionId;
    private String questionText;    // 문제 텍스트
    private String questionType;    // 문제 타입(객관식, OX, 용어 → 설명, 설명 → 용어)
    private List<SubmitAnswerResponseForm> answers;

    public static CreateQuizResponseForm from(CreateQuizResponse response) {

        List<SubmitAnswerResponseForm> convertedAnswers = response.getAnswers().stream()
                .map(answer -> new SubmitAnswerResponseForm(answer.getChoiceNumber(), answer.getChoiceText(), answer.isCorrect(), answer.getExplanation()))
                .collect(Collectors.toList());

        return new CreateQuizResponseForm(
//                response.getQuizSetId(),
//                response.getTermId(),
                response.getQuestionId(),
                response.getQuestionText(),
                response.getQuestionType(),
                convertedAnswers
        );
    }





}
