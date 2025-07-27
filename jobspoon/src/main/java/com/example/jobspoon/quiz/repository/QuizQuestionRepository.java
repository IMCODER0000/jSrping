package com.example.jobspoon.quiz.repository;

import com.example.jobspoon.quiz.entity.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {

}
