package com.example.jobspoon.term.controller.request_form;

import com.example.jobspoon.term.service.request.CreateTermRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class CreateTermRequestForm {
    private final String title;
    private final String description;

    public CreateTermRequest toCreateTermRequest() {
        return new CreateTermRequest(title, description);
    }

}
