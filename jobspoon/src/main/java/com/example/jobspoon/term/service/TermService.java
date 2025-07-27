package com.example.jobspoon.term.service;


import com.example.jobspoon.term.controller.response_form.TermResponseForm;
import com.example.jobspoon.term.service.request.CreateTermRequest;
import com.example.jobspoon.term.service.request.FindTermByTitleRequest;
import com.example.jobspoon.term.service.response.CreateTermResponse;
import com.example.jobspoon.term.service.response.FindTermByTitleResponse;
import com.example.jobspoon.term.service.response.ReadTermResponse;

import java.util.List;

public interface TermService {

    CreateTermResponse register(CreateTermRequest createTermRequest);
    List<TermResponseForm> findAllTerms();
    ReadTermResponse read(Long termId);
    FindTermByTitleResponse find(FindTermByTitleRequest findTermByTitleRequest);


}
