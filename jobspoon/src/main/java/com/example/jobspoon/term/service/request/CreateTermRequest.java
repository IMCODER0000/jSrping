package com.example.jobspoon.term.service.request;

import com.example.jobspoon.term.entity.Category;
import com.example.jobspoon.term.entity.Term;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class CreateTermRequest {

    private final String title;
    private final String description;
    private final String tags;         // ex: "#HTML #DOM"
    private final String categoryId;

    public Term toTerm(Category category) {
        return new Term(
                title,
                description,
                category
        );
    }
}