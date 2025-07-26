package com.example.jobspoon.dictionary.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class FindDictionaryByTitleRequest {
    private final String title;
}
