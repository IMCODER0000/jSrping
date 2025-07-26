package com.example.jobspoon.dictionary.service.response;

import com.example.jobspoon.dictionary.entity.Dictionary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class FindDictionaryResponse {
    private final Long termId;
    private final String title;
    private final String description;

    public static FindDictionaryResponse from(Dictionary dictionary){
        return new FindDictionaryResponse(
                dictionary.getTermId(),
                dictionary.getTitle(),
                dictionary.getDescription()
        );
    }
}
