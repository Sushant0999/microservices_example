package com.quiz.quizService.service;

import com.quiz.quizService.entity.Quiz;

import java.util.List;

public interface QuizService {

    Quiz add(Quiz quiz);

    List<Quiz> get();

    Quiz findById(Long id);

}
