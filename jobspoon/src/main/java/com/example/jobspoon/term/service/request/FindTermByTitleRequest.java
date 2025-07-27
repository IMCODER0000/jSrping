package com.example.jobspoon.term.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class FindTermByTitleRequest {
    private final String title;
}
