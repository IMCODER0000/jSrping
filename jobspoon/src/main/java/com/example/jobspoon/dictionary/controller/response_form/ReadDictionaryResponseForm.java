package com.example.jobspoon.dictionary.controller.response_form;

import com.example.jobspoon.dictionary.service.response.ReadDictionaryResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class ReadDictionaryResponseForm {

    private Long termId;
    private String title;
    private String description;

    public static ReadDictionaryResponseForm from(ReadDictionaryResponse response) {
        return new ReadDictionaryResponseForm(
                response.getTermId(),
                response.getTitle(),
                response.getDescription()
        );
    }

}
