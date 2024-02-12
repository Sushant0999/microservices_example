package com.quiz.quizService.repository;

import com.quiz.quizService.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {


}
