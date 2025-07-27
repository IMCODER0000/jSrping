package com.example.jobspoon.term.service.response;

import com.example.jobspoon.term.entity.Term;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateTermResponse {

    private final Long termId;
    private final String title;
    private final String description;

    public static CreateTermResponse from(Term term) {
        return new CreateTermResponse(
                term.getId(),
                term.getTitle(),
                term.getDescription()
        );
    }



}
