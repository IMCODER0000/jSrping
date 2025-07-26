package com.example.jobspoon.dictionary.controller.response_form;

import com.example.jobspoon.dictionary.service.response.FindDictionaryByTitleResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class FindDictionaryByTitleResponseForm {

    private final Long termId;
    private final String title;
    private final String description;

    public static FindDictionaryByTitleResponseForm from(FindDictionaryByTitleResponse response){
        return new FindDictionaryByTitleResponseForm(
                response.getTermId(),
                response.getTitle(),
                response.getDescription()
        );
    }

}
