package com.example.demo.dictionary.service.response;

import com.example.demo.dictionary.entity.Dictionary;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateDictionaryResponse {

    private final Long termId;
    private final String title;
    private final String description;

    public static CreateDictionaryResponse from(Dictionary dictionary) {
        return new CreateDictionaryResponse(
                dictionary.getTermId(),
                dictionary.getTitle(),
                dictionary.getDescription()
        );
    }



}
