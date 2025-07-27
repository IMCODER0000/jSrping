package com.example.jobspoon.term.controller.response_form;

import com.example.jobspoon.term.service.response.CreateTermResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateTermResponseForm {

    private final Long termId;
    private final String title;
    private final String description;

    public static CreateTermResponseForm from(CreateTermResponse response) {
        return new CreateTermResponseForm(
                response.getTermId(),
                response.getTitle(),
                response.getDescription()
        );
    }

}
