package com.example.jobspoon.quiz.entity;

import com.example.jobspoon.quiz.controller.response_form.SubmitAnswerResponseForm;
import com.example.jobspoon.term.entity.Term;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private QuizSet quizSet;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Term term;

    @Setter
    private String questionText;    // 문제 본문

    @Setter
    private String questionType;    // CHOICE, OX, TERM_TO_DESC, DESC_TO_TERM

    @Setter
    private int orderIndex;         // 퀴즈셋 내 정렬 순서

    public QuizQuestion(Long quizSetId, Long termId, String questionText, String questionType, List<SubmitAnswerResponseForm> answers) {
    }
}
