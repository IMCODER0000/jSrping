package com.example.jobspoon.term.controller.request_form;

import com.example.jobspoon.term.service.request.FindTermByTitleRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@ToString
@RequiredArgsConstructor
public class FindTermByTitleRequestForm {
    private final String title;

    public FindTermByTitleRequest toFindTermRequestByTitle() {
        return new FindTermByTitleRequest(title);
    }

}
