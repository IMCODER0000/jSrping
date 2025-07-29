package com.example.jobspoon.term.config;

import com.example.jobspoon.term.entity.Category;
import com.example.jobspoon.term.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) {
        if (categoryRepository.count() == 0) {
            Category cat = new Category(
                    "CAT001", "직무 중심", "Backend", "Spring", 2, 1, null
            );
            categoryRepository.save(cat);
        }
    }
}
