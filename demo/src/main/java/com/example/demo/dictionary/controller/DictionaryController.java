package com.example.demo.dictionary.controller;

import com.example.demo.dictionary.controller.request_form.CreateDictionaryRequestForm;
import com.example.demo.dictionary.controller.request_form.FindDictionaryByTitleRequestForm;
import com.example.demo.dictionary.controller.response_form.CreateDictionaryResponseForm;
import com.example.demo.dictionary.controller.response_form.DictionaryResponseForm;
import com.example.demo.dictionary.controller.response_form.FindDictionaryByTitleResponseForm;
import com.example.demo.dictionary.controller.response_form.ReadDictionaryResponseForm;
import com.example.demo.dictionary.service.DictionaryService;
import com.example.demo.dictionary.service.response.CreateDictionaryResponse;
import com.example.demo.dictionary.service.response.FindDictionaryByTitleResponse;
import com.example.demo.dictionary.service.response.ReadDictionaryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

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



}
