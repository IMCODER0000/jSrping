package com.example.jobspoon.quiz.entity;

import com.example.jobspoon.term.entity.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QuizSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;                   // ex) 오늘의 랜덤 퀴즈
    private String description;

    private boolean isRandom;               // 랜덤 생성 퀴즈셋인지 여부
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;              // 출제 분야 기준
}
