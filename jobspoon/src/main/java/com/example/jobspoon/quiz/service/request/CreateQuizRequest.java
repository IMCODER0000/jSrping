package com.example.jobspoon.quiz.service.request;

import com.example.jobspoon.quiz.controller.request_form.QuizChoiceForm;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class CreateQuizRequest {
//    private final Long quizSetId;         // QuizSet : 오늘의 랜덤 퀴즈 10문제, Front분야 OX 문제셋 등
    private final Long termId;            // 답과 관련되어 있는 용어 ID
    private final String questionText;    // 문제 텍스트
    private final String questionType;    // 문제 타입(객관식, OX, 용어 → 설명, 설명 → 용어)
    private final int correctChoiceNumber;
    private final List<QuizChoiceForm> choices;

}
