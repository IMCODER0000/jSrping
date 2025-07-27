package com.example.jobspoon.quiz.service.response;

import com.example.jobspoon.quiz.entity.QuizAnswer;
import com.example.jobspoon.quiz.entity.QuizQuestion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.IntStream;

@Getter
@RequiredArgsConstructor
public class CreateQuizResponse {

//    private final Long quizSetId;         // QuizSet : 오늘의 랜덤 퀴즈 10문제, Front분야 OX 문제셋 등
//    private final Long termId;            // 답과 관련되어 있는 용어 ID
    private final Long questionId;    // 문제 텍스트
    private final String questionText;    // 문제 텍스트
    private final String questionType;    // 문제 타입(객관식, OX, 용어 → 설명, 설명 → 용어)
    private final List<QuizAnswerResponse> answers;

    public static CreateQuizResponse from(QuizQuestion quizQuestion, List<QuizAnswer> answerList) {
        List<QuizAnswerResponse> answerForms = IntStream.range(0, answerList.size())
                .mapToObj(i -> {
                    QuizAnswer a = answerList.get(i);
                    return new QuizAnswerResponse(
                            i + 1, // 선택지 번호 (1~4)
                            a.getChoiceText(),
                            a.isCorrect(),
                            a.getQuizQuestion().getTerm() != null
                                    ? a.getQuizQuestion().getTerm().getDescription()
                                    : "설명이 없습니다"
                    );
                })
                .toList();

        return new CreateQuizResponse(
                quizQuestion.getId(),
                quizQuestion.getQuestionText(),
                quizQuestion.getQuestionType(),
                answerForms
        );
    }

}
