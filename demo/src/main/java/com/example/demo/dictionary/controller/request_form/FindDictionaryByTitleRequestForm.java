package com.example.demo.dictionary.controller.request_form;

import com.example.demo.dictionary.service.request.FindDictionaryByTitleRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@ToString
@RequiredArgsConstructor
public class FindDictionaryByTitleRequestForm {
    private final String title;

    public FindDictionaryByTitleRequest toFindDictionaryRequestByTitle() {
        return new FindDictionaryByTitleRequest(title);
    }

}
