package com.example.jobspoon.term.service;

import com.example.jobspoon.term.controller.response_form.TermResponseForm;
import com.example.jobspoon.term.entity.Term;
import com.example.jobspoon.term.repository.TermRepository;
import com.example.jobspoon.term.service.request.CreateTermRequest;
import com.example.jobspoon.term.service.request.FindTermByTitleRequest;
import com.example.jobspoon.term.service.response.CreateTermResponse;
import com.example.jobspoon.term.service.response.FindTermByTitleResponse;
import com.example.jobspoon.term.service.response.ReadTermResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TermServiceImpl implements TermService {

    private final TermRepository termRepository;

    @Override
    public CreateTermResponse register(CreateTermRequest createTermRequest) {
        Term term = termRepository.save(createTermRequest.toTerm());
        return CreateTermResponse.from(term);
    }

    @Override
    public List<TermResponseForm> findAllTerms() {
        List<Term> terms = termRepository.findAll();

        return termRepository.findAll().stream()
                .map(term -> new TermResponseForm(term.getId(), term.getTitle(), term.getDescription()))
                .collect(Collectors.toList());
    }

    @Override
    public ReadTermResponse read(Long termId) {
        Optional<Term> maybeTerm = termRepository.findById(termId);
        if(maybeTerm.isEmpty()){
            log.info("찾는 단어가 없습니다.");
            return null;
        }
        Term term = maybeTerm.get();
        return ReadTermResponse.from(term);
    }

    @Override
    public FindTermByTitleResponse find(FindTermByTitleRequest request) {
        Term term = termRepository.findByTitle(request.getTitle())
                .orElseThrow(() -> new IllegalArgumentException("해당 단어를 찾을 수 없습니다: " + request.getTitle()));

        return FindTermByTitleResponse.from(term);
    }
}
