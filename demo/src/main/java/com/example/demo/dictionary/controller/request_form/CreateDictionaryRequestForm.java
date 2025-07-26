package com.example.demo.dictionary.controller.request_form;

import com.example.demo.dictionary.service.request.CreateDictionaryRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class CreateDictionaryRequestForm {
    private final String title;
    private final String description;

    public CreateDictionaryRequest toCreateDictionaryRequest() {
        return new CreateDictionaryRequest(title, description);
    }

}
