package com.example.jobspoon.term.repository;

import com.example.jobspoon.term.entity.Term;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermRepository extends JpaRepository<Term, Long> {
}
