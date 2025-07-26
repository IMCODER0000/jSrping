package com.example.jobspoon.dictionary.controller;

import com.example.jobspoon.dictionary.controller.request_form.CreateDictionaryRequestForm;
import com.example.jobspoon.dictionary.controller.response_form.CreateDictionaryResponseForm;
import com.example.jobspoon.dictionary.controller.response_form.DictionaryResponseForm;
import com.example.jobspoon.dictionary.controller.request_form.FindDictionaryByTitleRequestForm;
import com.example.jobspoon.dictionary.controller.response_form.FindDictionaryByTitleResponseForm;
import com.example.jobspoon.dictionary.controller.response_form.ReadDictionaryResponseForm;
import com.example.jobspoon.dictionary.service.DictionaryService;
import com.example.jobspoon.dictionary.service.response.CreateDictionaryResponse;
import com.example.jobspoon.dictionary.service.response.FindDictionaryByTitleResponse;
import com.example.jobspoon.dictionary.service.response.ReadDictionaryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/dictionary")
public class DictionaryController {

    private final DictionaryService dictionaryService;

    // 데이터 입력
    @PostMapping("/terms")
    public CreateDictionaryResponseForm createTerm (@RequestBody CreateDictionaryRequestForm createDictionaryRequestForm) {
        CreateDictionaryResponse response = dictionaryService.register(createDictionaryRequestForm.toCreateDictionaryRequest());
        return CreateDictionaryResponseForm.from(response);
    }

    // 모든 사전 정보 다 가져오기
    @GetMapping("/lists")
    public List<DictionaryResponseForm> getAllDictionaries() {
        return dictionaryService.findAllDictionaries();
    }

    // 특정 id의 사전 정보 가져오기
    @GetMapping("/read/{termId}")
    public ReadDictionaryResponseForm readDictionary(@PathVariable("termId") Long termId) {
        log.info("dictionaryRead():{}", termId);
        ReadDictionaryResponse response = dictionaryService.read(termId);
        return ReadDictionaryResponseForm.from(response);
    }

    // 특정 이름의 사전 정보 가져오기
    @PostMapping("/find/by-title")
    public FindDictionaryByTitleResponseForm findDictionaryByTitleResponseForm (
            @RequestBody FindDictionaryByTitleRequestForm requestForm) {
        FindDictionaryByTitleResponse response = dictionaryService.find(requestForm.toFindDictionaryRequestByTitle());
        return FindDictionaryByTitleResponseForm.from(response);
    }


    // 문제에 카테고리 추가 => Entity에서

    // 답을 입력 받고 정답 확인 받기



}
