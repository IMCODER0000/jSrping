package com.example.demo.dictionary.service;

import com.example.demo.dictionary.controller.response_form.DictionaryResponseForm;
import com.example.demo.dictionary.service.request.CreateDictionaryRequest;
import com.example.demo.dictionary.service.request.FindDictionaryByTitleRequest;
import com.example.demo.dictionary.service.response.CreateDictionaryResponse;
import com.example.demo.dictionary.service.response.FindDictionaryByTitleResponse;
import com.example.demo.dictionary.service.response.ReadDictionaryResponse;

import java.util.List;

public interface DictionaryService {

    CreateDictionaryResponse register(CreateDictionaryRequest createDictionaryRequest);
    List<DictionaryResponseForm> findAllDictionaries();
    ReadDictionaryResponse read(Long termId);
    FindDictionaryByTitleResponse find(FindDictionaryByTitleRequest findDictionaryByTitleRequest);


}
