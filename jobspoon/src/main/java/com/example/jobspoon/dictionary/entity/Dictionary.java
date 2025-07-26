package com.example.jobspoon.dictionary.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long termId;

    @Setter
    private String title;

    @Setter
    private String description;

    public Dictionary(String title, String description) {
        this.title = title;
        this.description = description;
    }


}
