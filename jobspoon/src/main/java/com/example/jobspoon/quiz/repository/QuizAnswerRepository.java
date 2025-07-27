package com.example.jobspoon.quiz.repository;

import com.example.jobspoon.quiz.entity.QuizAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizAnswerRepository extends JpaRepository<QuizAnswer, Long> {
    List<QuizAnswer> findByQuizQuestionId(Long QuestionId);
}
