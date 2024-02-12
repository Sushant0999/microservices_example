package com.question.questionService.service.impl;

import com.question.questionService.entity.Question;
import com.question.questionService.repository.QuestionRepository;
import com.question.questionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question add(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND"));
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
