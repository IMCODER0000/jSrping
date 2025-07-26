package com.example.jobspoon.dictionary.service;

import com.example.jobspoon.dictionary.controller.response_form.DictionaryResponseForm;
import com.example.jobspoon.dictionary.entity.Dictionary;
import com.example.jobspoon.dictionary.repository.DictionaryRepository;
import com.example.jobspoon.dictionary.service.request.CreateDictionaryRequest;
import com.example.jobspoon.dictionary.service.request.FindDictionaryByTitleRequest;
import com.example.jobspoon.dictionary.service.response.CreateDictionaryResponse;
import com.example.jobspoon.dictionary.service.response.FindDictionaryByTitleResponse;
import com.example.jobspoon.dictionary.service.response.ReadDictionaryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DictionaryServiceImpl implements DictionaryService {

    private final DictionaryRepository dictionaryRepository;

    @Override
    public CreateDictionaryResponse register(CreateDictionaryRequest createDictionaryRequest) {
        Dictionary dictionary = dictionaryRepository.save(createDictionaryRequest.toDictionary());
        return CreateDictionaryResponse.from(dictionary);
    }

    @Override
    public List<DictionaryResponseForm> findAllDictionaries() {
        List<Dictionary> dictionaries = dictionaryRepository.findAll();

        return dictionaryRepository.findAll().stream()
                .map(dict -> new DictionaryResponseForm(dict.getTermId(), dict.getTitle(), dict.getDescription()))
                .collect(Collectors.toList());
    }

    @Override
    public ReadDictionaryResponse read(Long termId) {
        Optional<Dictionary> maybeDict = dictionaryRepository.findById(termId);
        if(maybeDict.isEmpty()){
            log.info("찾는 단어가 없습니다.");
            return null;
        }
        Dictionary dictionary = maybeDict.get();
        return ReadDictionaryResponse.from(dictionary);
    }

    @Override
    public FindDictionaryByTitleResponse find(FindDictionaryByTitleRequest request) {
        Dictionary dictionary = dictionaryRepository.findByTitle(request.getTitle())
                .orElseThrow(() -> new IllegalArgumentException("해당 단어를 찾을 수 없습니다: " + request.getTitle()));

        return FindDictionaryByTitleResponse.from(dictionary);
    }
}
