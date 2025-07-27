package com.example.jobspoon.term.service.response;

import com.example.jobspoon.term.entity.Term;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class FindTermResponse {
    private final Long termId;
    private final String title;
    private final String description;

    public static FindTermResponse from(Term term){
        return new FindTermResponse(
                term.getId(),
                term.getTitle(),
                term.getDescription()
        );
    }
}
