package com.example.jobspoon.term.repository;

import com.example.jobspoon.term.entity.Term;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TermRepository extends JpaRepository<Term, Long> {
    Optional<Term> findByTitle(String title);
}
