package com.quiz.quizService.controller;

import com.quiz.quizService.entity.Quiz;
import com.quiz.quizService.service.impl.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizServiceImpl quizService;

    @PostMapping("/add")
    public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok().body(quizService.add(quiz));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getQuiz(){
        return ResponseEntity.ofNullable(quizService.get());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ofNullable(quizService.findById(id));
    }

}
