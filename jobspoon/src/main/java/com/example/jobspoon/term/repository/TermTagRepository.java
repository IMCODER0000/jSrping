package com.example.jobspoon.term.repository;

import com.example.jobspoon.term.entity.TermTag;
import com.example.jobspoon.term.entity.TermTagId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermTagRepository extends JpaRepository<TermTag, TermTagId> {
}
