package com.question.questionService.service;


import com.question.questionService.entity.Question;

import java.util.List;

public interface QuestionService {
    Question add(Question question);

    List<Question> getAll();

    Question findById(Long id);

    List<Question> getQuestionsOfQuiz(Long quizId);
}
