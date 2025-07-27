package com.example.jobspoon.quiz.service;

import com.example.jobspoon.quiz.service.request.CreateQuizRequest;
import com.example.jobspoon.quiz.service.request.SubmitAnswerRequest;
import com.example.jobspoon.quiz.service.response.CreateQuizResponse;
import com.example.jobspoon.quiz.service.response.QuizAnswerResponse;

public interface QuizService {

    CreateQuizResponse register(CreateQuizRequest request);
    QuizAnswerResponse check(SubmitAnswerRequest request);

}
