package com.example.demo.dictionary.service.response;

import com.example.demo.dictionary.entity.Dictionary;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FindDictionaryByTitleResponse {

    private final Long termId;
    private final String title;
    private final String description;

    public static FindDictionaryByTitleResponse from(Dictionary dictionary) {
        return new FindDictionaryByTitleResponse(
                dictionary.getTermId(),
                dictionary.getTitle(),
                dictionary.getDescription()
        );
    }

}
