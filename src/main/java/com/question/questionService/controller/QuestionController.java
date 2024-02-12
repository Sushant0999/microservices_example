package com.question.questionService.controller;

import com.question.questionService.entity.Question;
import com.question.questionService.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionServiceImpl questionService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Question question){
        Question que = questionService.add(question);
        return ResponseEntity.ok().body(que);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ofNullable(questionService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ofNullable(questionService.findById(id));
    }

    @GetMapping("/get/quiz/{quizId}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable Long quizId){
        return ResponseEntity.ofNullable(questionService.getQuestionsOfQuiz(quizId));
    }


}
