package com.example.jobspoon.quiz.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QuizAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private QuizQuestion quizQuestion;

    @Setter
    private int choiceNumber;     // 보기 번호

    @Setter
    private String choiceText;    // 보기 내용

    @Setter
    private boolean isCorrect; // 정답 여부

}
