package com.quiz.quizService.service;

import com.quiz.quizService.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Here url = another service base address
//@FeignClient(url = "http://localhost:8082", value = "Question-Client")
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {

    // Here we use same mapping as we have used in Question Controller
    @GetMapping("/question/get/quiz/{quizId}")
    List<Question> getQuestionOfQuiz(@PathVariable Long quizId);

}
