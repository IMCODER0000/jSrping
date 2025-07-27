package com.example.jobspoon.quiz.service;

import com.example.jobspoon.quiz.entity.QuizAnswer;
import com.example.jobspoon.quiz.entity.QuizQuestion;
import com.example.jobspoon.quiz.repository.QuizAnswerRepository;
import com.example.jobspoon.quiz.repository.QuizQuestionRepository;
import com.example.jobspoon.quiz.service.request.CreateQuizRequest;
import com.example.jobspoon.quiz.service.request.SubmitAnswerRequest;
import com.example.jobspoon.quiz.service.response.CreateQuizResponse;
import com.example.jobspoon.quiz.service.response.QuizAnswerResponse;
import com.example.jobspoon.term.entity.Term;
import com.example.jobspoon.term.repository.TermRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

//    private final QuizSetRepository quizSetRepository;
    private final TermRepository termRepository;
    private final QuizQuestionRepository quizQuestionRepository;
    private final QuizAnswerRepository quizAnswerRepository;

    @Override
    public CreateQuizResponse register(CreateQuizRequest request) {

//        QuizSet quizSet = quizSetRepository.findById(request.getQuizSetId())
//                .orElseThrow(() -> new IllegalArgumentException("퀴즈셋이 존재하지 않습니다."));
//
        Term term = termRepository.findById(request.getTermId())
                .orElseThrow(() -> new IllegalArgumentException("해당 용어가 존재하지 않습니다."));

        // QuizQuestion 생성
        QuizQuestion question = new QuizQuestion();
//        question.setQuizSet(quizSet);
        question.setTerm(term);
        question.setQuestionText(request.getQuestionText());
        question.setQuestionType(request.getQuestionType());
        QuizQuestion savedQuestion = quizQuestionRepository.save(question);

        // 정답/보기 저장
        List<QuizAnswer> savedAnswers = request.getChoices().stream()
                .map(choiceForm -> {
                    QuizAnswer answer = new QuizAnswer();
                    answer.setQuizQuestion(savedQuestion);
                    answer.setChoiceNumber(choiceForm.getChoiceNumber());
                    answer.setChoiceText(choiceForm.getChoiceText());
                    answer.setCorrect(choiceForm.getChoiceNumber() == request.getCorrectChoiceNumber());
                    return quizAnswerRepository.save(answer);
                })
                .toList();
        return CreateQuizResponse.from(savedQuestion, savedAnswers);
    }

    @Override
    public QuizAnswerResponse check(SubmitAnswerRequest request) {

        QuizQuestion question = quizQuestionRepository.findById(request.getQuestionId())
                .orElseThrow(() -> new IllegalArgumentException("해당 문제를 찾을 수 없습니다." + request.getQuestionId()));

        List<QuizAnswer> answerList = quizAnswerRepository.findByQuizQuestionId(request.getQuestionId());

        if(request.getChoiceNumber()<1 || request.getChoiceNumber() > answerList.size()) {
            throw new IllegalArgumentException("선택한 보기 번호가 유효하지 않습니다.");
        }

        // 학습자가 고르는 보기는 1부터 시작한다고 가정
        QuizAnswer selectedAnswer = answerList.get(request.getChoiceNumber() - 1);
        boolean isCorrect = selectedAnswer.isCorrect();
        String explanation = question.getTerm() != null ? question.getTerm().getDescription() : "해설이 없습니다.";

        return new QuizAnswerResponse(
                request.getChoiceNumber(),
                selectedAnswer.getChoiceText(),
                isCorrect,
                explanation
        );
    }
}
