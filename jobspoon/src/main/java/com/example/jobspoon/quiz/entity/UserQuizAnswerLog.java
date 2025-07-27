package com.example.jobspoon.quiz.entity;

import jakarta.persistence.*;

@Entity
public class UserQuizAnswerLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserQuizResult quizResult;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuizQuestion question;

    private String selectedAnswerText;
    private boolean isCorrect;
}
