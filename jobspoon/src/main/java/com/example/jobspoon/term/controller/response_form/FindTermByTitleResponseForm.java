package com.example.jobspoon.term.controller.response_form;

import com.example.jobspoon.term.service.response.FindTermByTitleResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class FindTermByTitleResponseForm {

    private final Long termId;
    private final String title;
    private final String description;

    public static FindTermByTitleResponseForm from(FindTermByTitleResponse response){
        return new FindTermByTitleResponseForm(
                response.getTermId(),
                response.getTitle(),
                response.getDescription()
        );
    }

}
