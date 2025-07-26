package com.example.jobspoon.dictionary.service;


import com.example.jobspoon.dictionary.controller.response_form.DictionaryResponseForm;
import com.example.jobspoon.dictionary.service.request.CreateDictionaryRequest;
import com.example.jobspoon.dictionary.service.request.FindDictionaryByTitleRequest;
import com.example.jobspoon.dictionary.service.response.CreateDictionaryResponse;
import com.example.jobspoon.dictionary.service.response.FindDictionaryByTitleResponse;
import com.example.jobspoon.dictionary.service.response.ReadDictionaryResponse;

import java.util.List;

public interface DictionaryService {

    CreateDictionaryResponse register(CreateDictionaryRequest createDictionaryRequest);
    List<DictionaryResponseForm> findAllDictionaries();
    ReadDictionaryResponse read(Long termId);
    FindDictionaryByTitleResponse find(FindDictionaryByTitleRequest findDictionaryByTitleRequest);


}
