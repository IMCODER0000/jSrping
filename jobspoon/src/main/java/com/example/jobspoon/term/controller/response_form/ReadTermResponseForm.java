package com.example.jobspoon.term.controller.response_form;

import com.example.jobspoon.term.service.response.ReadTermResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class ReadTermResponseForm {

    private Long termId;
    private String title;
    private String description;

    public static ReadTermResponseForm from(ReadTermResponse response) {
        return new ReadTermResponseForm(
                response.getTermId(),
                response.getTitle(),
                response.getDescription()
        );
    }

}
