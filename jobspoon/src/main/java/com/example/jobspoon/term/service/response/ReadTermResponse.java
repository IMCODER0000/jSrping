package com.example.jobspoon.term.service.response;

import com.example.jobspoon.term.entity.Term;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ReadTermResponse {
    private final Long termId;
    private final String title;
    private final String description;

    public static ReadTermResponse from(Term term) {
        return new ReadTermResponse(
                term.getId(),
                term.getTitle(),
                term.getDescription()
        );
    }
}
