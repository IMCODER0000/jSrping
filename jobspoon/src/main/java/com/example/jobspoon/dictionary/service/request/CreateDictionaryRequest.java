package com.example.jobspoon.dictionary.service.request;

import com.example.jobspoon.dictionary.entity.Dictionary;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class CreateDictionaryRequest {
    private final String title;
    private final String description;

    public Dictionary toDictionary() {
        return new Dictionary(title, description);
    }
}
