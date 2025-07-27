package com.example.jobspoon.quiz.entity;

import jakarta.persistence.*;
import org.apache.catalina.User;

import java.time.LocalDateTime;

@Entity
public class UserQuizResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuizSet quizSet;

    private LocalDateTime submittedAt;
    private int totalScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_result_id")
    private UserQuizResult quizResult;

}
