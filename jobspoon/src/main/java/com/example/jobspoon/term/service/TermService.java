package com.example.jobspoon.term.service;


import com.example.jobspoon.term.service.request.CreateTermRequest;
import com.example.jobspoon.term.service.response.CreateTermResponse;

public interface TermService {
    CreateTermResponse register(CreateTermRequest createTermRequest);

}
