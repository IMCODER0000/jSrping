package com.example.jobspoon.term.service.request;

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

    public Term toTerm() {
        return new Term(title, description);
    }
}
