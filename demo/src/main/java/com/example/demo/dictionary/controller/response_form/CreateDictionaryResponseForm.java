package com.example.demo.dictionary.controller.response_form;

import com.example.demo.dictionary.service.response.CreateDictionaryResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateDictionaryResponseForm {

    private final Long termId;
    private final String title;
    private final String description;

    public static CreateDictionaryResponseForm from(CreateDictionaryResponse response) {
        return new CreateDictionaryResponseForm(
                response.getTermId(),
                response.getTitle(),
                response.getDescription()
        );
    }

}
