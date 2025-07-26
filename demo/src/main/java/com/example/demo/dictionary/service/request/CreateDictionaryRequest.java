package com.example.demo.dictionary.service.request;

import com.example.demo.dictionary.entity.Dictionary;
import lombok.*;

@Getter
@ToString
@RequiredArgsConstructor
public class CreateDictionaryRequest {
    private final String title;
    private final String description;

    public CreateDictionaryRequest() {
    }

    public Dictionary toDictionary() {
        return new Dictionary(title, description);
    }
}
