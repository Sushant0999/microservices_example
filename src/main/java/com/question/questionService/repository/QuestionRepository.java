package com.question.questionService.repository;

import com.question.questionService.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    //Custom finder Method use findBy${entityName}
    List<Question> findByQuizId(Long quizId);

}
