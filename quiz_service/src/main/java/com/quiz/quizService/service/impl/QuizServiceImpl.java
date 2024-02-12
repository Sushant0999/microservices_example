package com.quiz.quizService.service.impl;

import com.quiz.quizService.entity.Quiz;
import com.quiz.quizService.repository.QuizRepository;
import com.quiz.quizService.service.QuestionClient;
import com.quiz.quizService.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizRepository.findAll();
        return quizzes.stream().peek(quiz -> quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getQuizId()))).toList();
    }

    @Override
    public Quiz findById(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getQuizId()));
        return quiz;
    }
}
