package com.example.jobspoon.term.controller;

import com.example.jobspoon.term.controller.request_form.CreateTermRequestForm;
import com.example.jobspoon.term.controller.response_form.CreateTermResponseForm;
import com.example.jobspoon.term.controller.response_form.TermResponseForm;
import com.example.jobspoon.term.controller.request_form.FindTermByTitleRequestForm;
import com.example.jobspoon.term.controller.response_form.FindTermByTitleResponseForm;
import com.example.jobspoon.term.controller.response_form.ReadTermResponseForm;
import com.example.jobspoon.term.service.TermService;
import com.example.jobspoon.term.service.response.CreateTermResponse;
import com.example.jobspoon.term.service.response.FindTermByTitleResponse;
import com.example.jobspoon.term.service.response.ReadTermResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/terms")
public class TermController {

    private final TermService termService;

    // 데이터 입력
    @PostMapping
    public CreateTermResponseForm createTerm (@RequestBody CreateTermRequestForm createTermRequestForm) {
        CreateTermResponse response = termService.register(createTermRequestForm.toCreateTermRequest());
        return CreateTermResponseForm.from(response);
    }

    // 모든 사전 정보 다 가져오기
    @GetMapping("/lists")
    public List<TermResponseForm> getAllTerms() {
        return termService.findAllTerms();
    }

    // 특정 id의 사전 정보 가져오기
    @GetMapping("/read/{termId}")
    public ReadTermResponseForm readTerm(@PathVariable("termId") Long termId) {
        log.info("termId: {}", termId);
        ReadTermResponse response = termService.read(termId);
        return ReadTermResponseForm.from(response);
    }

    // 특정 이름의 사전 정보 가져오기
    @PostMapping("/find/by-title")
    public FindTermByTitleResponseForm findTermByTitleResponseForm (
            @RequestBody FindTermByTitleRequestForm requestForm) {
        FindTermByTitleResponse response = termService.find(requestForm.toFindTermRequestByTitle());
        return FindTermByTitleResponseForm.from(response);
    }






}
