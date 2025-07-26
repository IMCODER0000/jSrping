package com.example.jobspoon.dictionary.repository;

import com.example.jobspoon.dictionary.entity.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {
    Optional<Dictionary> findByTitle(String title);
}
