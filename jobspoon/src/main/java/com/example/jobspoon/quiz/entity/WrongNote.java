package com.example.jobspoon.quiz.entity;

import com.example.jobspoon.term.entity.Term;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.catalina.User;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WrongNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Term term; // 틀린 용어 기반 저장

    private int mistakeCount;
    private LocalDateTime lastMistakenAt;
}
