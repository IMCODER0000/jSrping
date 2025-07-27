package com.example.jobspoon.quiz.controller.request_form;

import com.example.jobspoon.quiz.service.request.CreateQuizRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class CreateQuizRequestForm {

//    private final Long quizSetId;                 // QuizSet : 오늘의 랜덤 퀴즈 10문제, Front분야 OX 문제셋 등
    private final Long termId;                      // 답과 관련되어 있는 용어 ID
    private final String questionText;              // 문제 텍스트
    private final String questionType;              // 문제 타입(선다형, 진위형)
    private final int correctChoiceNumber;          // 정답 번호
    private final List<QuizChoiceForm> choices;


//    public CreateQuizRequest toCreateQuizRequest() {
//        return new CreateQuizRequest(quizSetId, termId, questionText, questionType, answers);
//    }

    public CreateQuizRequest toCreateQuizRequest() {
        return new CreateQuizRequest(termId, questionText, questionType, correctChoiceNumber, choices);
    }

}
