package com.example.jobspoon.term.repository;

import com.example.jobspoon.term.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findById(String categoryId);
}
