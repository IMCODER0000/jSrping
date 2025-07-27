package com.example.jobspoon.quiz.controller;

import com.example.jobspoon.quiz.controller.request_form.CreateQuizRequestForm;
import com.example.jobspoon.quiz.controller.request_form.QuizChoiceForm;
import com.example.jobspoon.quiz.controller.response_form.CreateQuizResponseForm;
import com.example.jobspoon.quiz.controller.response_form.SubmitAnswerResponseForm;
import com.example.jobspoon.quiz.service.QuizService;
import com.example.jobspoon.quiz.service.response.CreateQuizResponse;
import com.example.jobspoon.quiz.service.response.QuizAnswerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService quizService;

    // 문제에 카테고리 추가 => Entity
    @PostMapping("/questions")
    public CreateQuizResponseForm registerQuestion (@RequestBody CreateQuizRequestForm requestForm) {
        log.info("퀴즈 문제 등록 요청: {}", requestForm);
        CreateQuizResponse response = quizService.register(requestForm.toCreateQuizRequest());
        return CreateQuizResponseForm.from(response);
    }

    // 답을 입력받고 정답 확인받기
    @PostMapping("/answer")
    public SubmitAnswerResponseForm checkAnswer (@RequestBody QuizChoiceForm requestForm) {
        log.info("정답 확인: {}", requestForm);
        QuizAnswerResponse response = quizService.check(requestForm.toCheckAnswer());
        return SubmitAnswerResponseForm.from(response);
    }






}
